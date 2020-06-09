package AESPackage;

import java.util.Base64;
import javax.crypto.Cipher;

public class AES {

    public static String encrypt(String cleartext, AESKey key) {
        try {
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, key.secretKey);
            return Base64.getEncoder().encodeToString(cipher.doFinal(cleartext.getBytes("UTF-8")));
        } catch (Exception e) {
            System.out.println("Error while encrypting: " + e.toString());
        }
        return null;
    }

    public static String decrypt(String chipertext, AESKey key) {
        try {
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5PADDING");
            cipher.init(Cipher.DECRYPT_MODE, key.secretKey);
            return new String(cipher.doFinal(Base64.getDecoder().decode(chipertext)));
        } catch (Exception e) {
            System.out.println("Error while decrypting: " + e.toString());
        }
        return null;
    }
}
