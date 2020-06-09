package AESPackage;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.spec.SecretKeySpec;

public class AESKey {

    public static SecretKeySpec secretKey;
    private static byte[] tmp;

    public AESKey(String inKey) {
        MessageDigest sha = null;
        try {
            tmp = inKey.getBytes("UTF-8");
            sha = MessageDigest.getInstance("SHA-1");
            tmp = sha.digest(tmp);
            tmp = Arrays.copyOf(tmp, 16);
            secretKey = new SecretKeySpec(tmp, "AES");
        } catch (NoSuchAlgorithmException e) {
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(AESKey.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
