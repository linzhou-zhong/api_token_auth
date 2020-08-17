import storage.CredentialStorage;
import storage.MysqlCredentialStorage;

/**
 * @program: API_AUTH_PROJECT
 * @description: TODO
 * @author: Linzhou
 * @create: 2020/08/17 14:28
 **/
public class DefaultApiAuthenticatorImpl implements ApiAuthenticator{
    private CredentialStorage credentialStorage;

    public DefaultApiAuthenticatorImpl(){
        this.credentialStorage = new MysqlCredentialStorage();
    }

    public DefaultApiAuthenticatorImpl(CredentialStorage storage){
        this.credentialStorage = storage;
    }

    @Override
    public void auth(String url) {
        ApiRequest apiRequest = ApiRequest.createFromFullUrl(url);
        auth(apiRequest);
    }

    @Override
    public void auth(ApiRequest apiRequest) {
        String appId = apiRequest.getAppId();
        String token = apiRequest.getToken();
        long timestamp = apiRequest.getTimestamp();
        String originalUrl = apiRequest.getBaseUrl();
        String password = credentialStorage.getPasswordByAppId(appId);

        AuthToken clientAuthToken = new AuthToken(token, timestamp);
        AuthToken serverAuthToken = AuthToken.generate(originalUrl, appId, timestamp, password);

        if (clientAuthToken.isExpired())
            throw new RuntimeException("Token is expired");

        if (!serverAuthToken.math(clientAuthToken))
            throw new RuntimeException("Token verification failed");
    }
}
