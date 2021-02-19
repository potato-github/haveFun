package aes;

import java.math.BigInteger;
import java.security.MessageDigest;

public class MD5Util {
    public static String getMD5(String key) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(key.getBytes());
            return new BigInteger(1,md.digest()).toString();
        } catch (Exception e) {
            return null;
        }
    }
}
