package aes;


import com.sun.org.apache.regexp.internal.REUtil;
import org.apache.commons.lang.StringUtils;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.security.SecureRandom;
import java.security.spec.KeySpec;
import java.util.Base64;

public class AESUtil {



    public static String decrypt(String data, String key) {
        return doAES(data,MD5Util.getMD5(key), Cipher.DECRYPT_MODE);
    }

    public static String encrypt(String data, String key) {
        return doAES(data,MD5Util.getMD5(key), Cipher.ENCRYPT_MODE);
    }

    private static String doAES(String data, String key, int mode) {
        try {
            if (StringUtils.isBlank(data) || StringUtils.isBlank(key)){
                return null;
            }
            boolean encrypt = mode == Cipher.ENCRYPT_MODE;
            byte[] content;
            if (encrypt) {
                content = data.getBytes("UTF-8");
            } else {
                content = Base64.getDecoder().decode(data);
            }
            KeyGenerator kgen = KeyGenerator.getInstance("AES");
            SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG");
            secureRandom.setSeed(key.getBytes());
            kgen.init(128,secureRandom);

            SecretKey secretKey = kgen.generateKey();
            byte[] enCodeFormat = secretKey.getEncoded();
            SecretKeySpec secretKeySpec = new SecretKeySpec(enCodeFormat,"AES");
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(mode, secretKeySpec);
            byte[] result = cipher.doFinal(content);
            if (encrypt) {
                return Base64.getEncoder().encodeToString(result);
            } else {
                return new String(result, "UTF-8");
            }
        } catch (Exception e) {
            return null;
        }
    }
}
