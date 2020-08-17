/**
 * @program: API_AUTH_PROJECT
 * @description: TODO
 * @author: Linzhou
 * @create: 2020/08/17 14:58
 **/

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;
public class DefaultApiAuthenticatorImplTest {
    private static ApiAuthenticator authenticator;
    @BeforeAll
    public static void before(){
        authenticator = new DefaultApiAuthenticatorImpl();
    }

    @Test
    public void test_Success(){
        String baseUrl = "/auth/queryResources";
        String appiId = "1001";
        long timestamp = System.currentTimeMillis();
        String password = "PASS-1001";
        String token = AuthToken.generateTokenString(baseUrl, appiId, timestamp, password);
        ApiRequest req = new ApiRequest(baseUrl, appiId, token, timestamp);
        authenticator.auth(req);
    }

    @Test
    public void test_passwordWrong(){
        String baseUrl = "/auth/queryResources";
        String appiId = "1001";
        long timestamp = System.currentTimeMillis();
        String password = "0000";
        String token = AuthToken.generateTokenString(baseUrl, appiId, timestamp, password);
        ApiRequest req = new ApiRequest(baseUrl, appiId, token, timestamp);
        authenticator.auth(req);
    }

    @Test
    public void test_tokenExpired(){
        String baseUrl = "/auth/queryResources";
        String appiId = "1001";
        long timestamp = System.currentTimeMillis() + 1 * 60 * 1000;
        String password = "PASS-1001";
        String token = AuthToken.generateTokenString(baseUrl, appiId, timestamp, password);
        ApiRequest req = new ApiRequest(baseUrl, appiId, token, timestamp);
        authenticator.auth(req);
    }
}
