package storage;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: API_AUTH_PROJECT
 * @description: TODO
 * @author: Linzhou
 * @create: 2020/08/17 14:22
 **/
public class MysqlCredentialStorage implements CredentialStorage{
    private static Map<String, String> passwordMap = new HashMap<>();
    static {
        passwordMap.put("1001", "PASS-1001");
        passwordMap.put("1002", "PASS-1002");
        passwordMap.put("1003", "PASS-1003");
        passwordMap.put("1004", "PASS-1004");
        passwordMap.put("1005", "PASS-1005");
    }

    @Override
    public String getPasswordByAppId(String appId) {
        try{
            if (!passwordMap.containsKey(appId))
                throw new RuntimeException("Cannot find this appId: " + appId);
        }
        catch (RuntimeException e){
            e.printStackTrace();
        }
        return passwordMap.get(appId);
    }
}
