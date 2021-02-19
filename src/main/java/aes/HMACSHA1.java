package aes;



//import com.baidu.aip.util.Base64Util;

import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class HMACSHA1 {
    public static String hmac(String text,String key) throws Exception {
        byte[] data = HmacSHA1Encrypt(text,key);
        if (data != null) {
            //return Base64Util.encode(data);
        }
        return "";
    }
    private static byte[] HmacSHA1Encrypt(String text,String key) throws Exception {
        byte[] data = key.getBytes("UTF-8");
        SecretKey secretKey = new SecretKeySpec(data,"HmacSHA1");
        Mac mac = Mac.getInstance("HmacSHA1");
        mac.init(secretKey);
        byte[] textByte = text.getBytes("UTF-8");
        return mac.doFinal(textByte);
    }
}
