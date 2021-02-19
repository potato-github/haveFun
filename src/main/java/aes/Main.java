package aes;

import com.sun.crypto.provider.HmacSHA1;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws Exception {
        String encrypt = AESUtil.encrypt("a", "123456");
        System.out.println("encrypt:"+encrypt);

        String decrypt = AESUtil.decrypt(encrypt, "123456");
        System.out.println("encrypt:"+decrypt);

        Map<String,Object> map = new HashMap<String,Object>();
        map.put("channel","C9");
        map.put("format","json");
        map.put("requestId","abc123");
        map.put("version","1.0");
        Long timestamp = System.currentTimeMillis();
        map.put("timestamp",timestamp);
        String signature = SignHelper.getSignStr(map);
        signature = HMACSHA1.hmac("123456"+signature,"123456");
        System.out.println(signature);
    }
}
