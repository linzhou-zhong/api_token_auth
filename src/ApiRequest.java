/**
 * @program: API_AUTH_PROJECT
 * @description: TODO
 * @author: Linzhou
 * @create: 2020/08/17 12:38
 **/
public class ApiRequest {
    private String baseUrl;
    private String token;
    private String appId;
    private long timestamp;

    public ApiRequest(String baseUrl, String appId, String token, long timestamp){
        this.baseUrl = baseUrl;
        this.token = token;
        this.appId = appId;
        this.timestamp = timestamp;
    }

    public static ApiRequest createFromFullUrl(String url){
        // baseUrl=urlxxx & appId=1001 & token=98f6bcd4621d373cade4e832627b4f6 & timestamp=14088400
        String [] reqArray = url.split("&");
        String baseUrl = reqArray[0].split("=", 2)[1];
        String appId = reqArray[1].split("=", 2)[1];
        String token = reqArray[2].split("=", 2)[1];
        long timestamp = Long.parseLong(reqArray[3].split("=", 2)[1]);
        return new ApiRequest(baseUrl, appId, token, timestamp);
    }

    public String getBaseUrl(){
        return this.baseUrl;
    }

    public String getToken(){
        return this.token;
    }

    public String getAppId(){
        return this.appId;
    }

    public long getTimestamp(){
        return this.timestamp;
    }
}
