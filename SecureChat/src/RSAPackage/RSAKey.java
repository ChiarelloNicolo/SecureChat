package RSAPackage;

import java.math.BigInteger;

public class RSAKey {

    public BigInteger exponent;
    public BigInteger module;

    public RSAKey() {
        exponent = new BigInteger("0");
        module = new BigInteger("0");

    }

    public RSAKey(String exponentValue, String moduleValue) {
        exponent = new BigInteger(exponentValue);
        module = new BigInteger(moduleValue);

    }

}
