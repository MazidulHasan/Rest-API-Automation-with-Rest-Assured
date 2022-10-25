package apiConfigs;

import java.util.HashMap;
import java.util.Map;

public class HeadConfigs {
    public HeadConfigs(){

    }

    public Map<String,String > defaultHeaders(){
        Map<String,String> defaultHeaders = new HashMap<String ,String >();
        defaultHeaders.put("Content-Type","application/json");
        return defaultHeaders;
    }

    public Map<String,String > headerWithToken(){
        Map<String,String> headerWithToken = new HashMap<String ,String >();
        headerWithToken.put("Content-Type","application/json");
        headerWithToken.put("Access_token","thsIsTheAccessToken");
        headerWithToken.put("jwt_token","thisIsTheJwtToken");
        return headerWithToken;
    }
}
