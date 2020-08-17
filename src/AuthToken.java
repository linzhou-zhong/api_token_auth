import util.MD5Utils;

import java.util.Map;

/**
 * @program: API_AUTH_PROJECT
 * @description: TODO
 * @author: Linzhou
 * @create: 2020/08/17 12:14
 **/
public class AuthToken {
    private static final long DEFAULT_EXPIRED_TIME_INTERVAL = 1 * 60 * 1000;
    private String token;
    private long createTime;
    private long expiredTimeInterval = DEFAULT_EXPIRED_TIME_INTERVAL;

    public AuthToken(String token, long createTime){
        this.token = token;
        this.createTime = createTime;
    }

    public AuthToken(String token, long createTime, long expiredTimeInterval){
        this(token, createTime);
        this.expiredTimeInterval = expiredTimeInterval;
    }

    public static AuthToken create(String baseUrl, long createTime, Map<String, String> params){
        // merge with URL, AppID, password, timestamp to a string
        return null;
    }

    public static AuthToken generate(String originalUrl, String appId, long timestamp, String password){
        String token = generateTokenString(originalUrl, appId, timestamp, password);
        AuthToken authToken = new AuthToken(token, timestamp);
        return authToken;
    }

    public static String generateTokenString(String originalUrl, String appId, long timestamp, String password){
        String str = originalUrl + appId + timestamp + password;
        return MD5Utils.md5(str);
    }

    public String getToken(){
        return this.token;
    }

    public boolean isExpired(){
        long currentTime = System.currentTimeMillis(); // get current time in long
        return (currentTime - createTime > this.expiredTimeInterval);
    }

    public boolean math(AuthToken authToken){
        return this.token.equals(authToken.getToken());
    }
}
