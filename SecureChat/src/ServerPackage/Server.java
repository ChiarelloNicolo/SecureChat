package ServerPackage;

import java.io.*;
import java.net.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Server {

    ServerSocket Server;
    Socket Client;
    private BufferedReader inBuf;
    private PrintWriter outBuf;

    public Server() throws IOException {
        Server = new ServerSocket(0);
        Client = Server.accept();
        inBuf = null;
        outBuf = null;
    }

    public Server(String address, int port, int backlog) throws Exception {
        try {
            Server = new ServerSocket(port, backlog, InetAddress.getByName(address));
            Client = Server.accept();
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            inBuf = new BufferedReader(new InputStreamReader(Client.getInputStream()));
            outBuf = new PrintWriter(Client.getOutputStream());
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String read() throws IOException {
        return inBuf.readLine();
    }

    public void write(String toWrite) {
        outBuf.println(toWrite);
        outBuf.flush();
    }

    public void close() throws IOException {
        Client.close();
        Server.close();
    }

}
