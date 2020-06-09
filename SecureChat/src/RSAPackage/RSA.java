package RSAPackage;

import java.math.BigInteger;

public class RSA {

    public static BigInteger Convert(RSAKey Key, BigInteger textchar) {
        return textchar.modPow(Key.exponent, Key.module);
    }

    public static String Encrypt(String cleartext, RSAKey key) {
        String chipertext = "";
        for (int i = 0; i < cleartext.length(); i++) {
            int chr = (int) cleartext.charAt(i);
            String chstr = Integer.toString(chr);
            BigInteger BI = new BigInteger(chstr);
            if (i == cleartext.length() - 1) {
                chipertext = chipertext + Convert(key, BI).toString();
            } else {
                chipertext = chipertext + Convert(key, BI).toString() + ",";

            }
        }

        return chipertext;
    }

    public static String Decrypt(String chipertext, RSAKey key) {
        String cleartext = "";
        String[] chiperarr;
        chiperarr = chipertext.split(",");
        for (int i = 0; i < chiperarr.length; i++) {
            BigInteger BI = new BigInteger(chiperarr[i]);
            cleartext = cleartext + (char) Convert(key, BI).intValueExact();
        }
        return cleartext;

    }
}
