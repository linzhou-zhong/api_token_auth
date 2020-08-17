package util;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @program: API_AUTH_PROJECT
 * @description: TODO
 * @author: Linzhou
 * @create: 2020/08/17 13:24
 **/
public class MD5Utils {
    public static final String KEY_MD5 = "MD5";

    public static String md5(String inputStr){
        System.out.println("Before encryption: " + inputStr);
        BigInteger bigInteger = null;

        try{
            MessageDigest md = MessageDigest.getInstance(KEY_MD5);
            byte[] inputData = inputStr.getBytes();
            md.update(inputData);
            bigInteger = new BigInteger(md.digest());

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        System.out.println("After encryption : " + bigInteger.toString(16));
        return bigInteger.toString(16);
    }
}
