package UtilsPackage;

import AESPackage.AES;
import AESPackage.AESKey;
import RSAPackage.RSA;
import RSAPackage.RSAKey;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DecryptedMessage {

    public String DecryptedMessage;
    private RSAKey reciverPrivate;
    private RSAKey senderPublic;
    private String[] tmp;
    private AESKey aesKey;
    private String cleartextsha;
    private MessageDigest sha;
    private String recivedsha;

    public DecryptedMessage(String chipertext, RSAKey sender, RSAKey reciver) throws Exception {
        try {
            reciverPrivate = reciver;
            senderPublic = sender;
            sha = MessageDigest.getInstance("SHA-256");
            tmp = chipertext.split("////", 2);
            aesKey = new AESKey(RSA.Decrypt(tmp[1], reciverPrivate));
            tmp = AES.decrypt(tmp[0], aesKey).split("////", 2);
            System.out.println(tmp[0]);
            byte[] bytes = sha.digest(tmp[0].getBytes("UTF-8"));
            StringBuilder sb = new StringBuilder();
            for (byte b : bytes) {
                sb.append(String.format("%02X", b));
            }
            cleartextsha = sb.toString();
            recivedsha = RSA.Decrypt(tmp[1], senderPublic);
            if (recivedsha.equals(cleartextsha)) {
                DecryptedMessage = tmp[0];
            } else {
                DecryptedMessage = "The two digests didn't match";
            }
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(DecryptedMessage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
