package UtilsPackage;

import AESPackage.*;
import RSAPackage.*;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EncryptedMessage {

    public String EncryptedMessage;
    private AESKey AESKey;
    private RSAKey senderPrivate;
    private RSAKey reciverPublic;
    private String AEStmp;
    private MessageDigest sha;
    private String cleartextsha;

    public EncryptedMessage(String cleartext, RSAKey sender, RSAKey reciver) throws UnsupportedEncodingException {
        try {
            reciverPublic = reciver;
            senderPrivate = sender;
            AEStmp = RandomString.randomAlphaNumeric(20);
            AESKey = new AESKey(AEStmp);
            sha = MessageDigest.getInstance("SHA-256");
            byte[] bytes = sha.digest(cleartext.getBytes("UTF-8"));
            StringBuilder sb = new StringBuilder();
            for (byte b : bytes) {
                sb.append(String.format("%02X", b));
            }
            cleartextsha = sb.toString();
            String tmp = cleartext + "////" + RSA.Encrypt(cleartextsha, senderPrivate); //cripto l'hash con RSA usando ASCII (mia chiave privata)
            tmp = AES.encrypt(tmp, AESKey);
            EncryptedMessage = tmp + "////" + RSA.Encrypt(AEStmp, reciverPublic); // cripto AEStmp con la chiave pubblica del destinatario RSA/ascii
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(EncryptedMessage.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
