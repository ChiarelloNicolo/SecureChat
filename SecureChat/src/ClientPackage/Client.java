/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClientPackage;

import java.io.*;
import java.net.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Utente
 */
public class Client {
    
    Socket Server;
    private BufferedReader inBuf;
    private PrintWriter outBuf;
    
    public Client(){
        Server = new Socket();
        inBuf = null;
        outBuf = null;
    }
    
    public Client(String address, int port) throws IOException{
        try {
            Server = new Socket(InetAddress.getByName(address), port);
        } catch (UnknownHostException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
        inBuf = new BufferedReader(new InputStreamReader(Server.getInputStream()));
        outBuf = new PrintWriter(Server.getOutputStream());
    }
    
    public String read() throws IOException {
        return inBuf.readLine();
    }
    
    public void write(String toWrite){
        outBuf.println(toWrite);
        outBuf.flush();
    }
    
    public void close() throws IOException{
        Server.close();
    }
}
