package apiBuilders;

import utils.JavaUtils;

import java.util.HashMap;
import java.util.Map;

public class PostApiBuilder {
    public Map<String ,String > postRequestBody(){
        Map<String ,String > body = new HashMap<String ,String >();
        body.put("name", JavaUtils.randomNumebr());
        body.put("job",JavaUtils.randomStrig());
        return body;
    }
}
