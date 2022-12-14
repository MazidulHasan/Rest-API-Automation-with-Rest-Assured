package apiVerifications;

import com.relevantcodes.extentreports.LogStatus;
import io.restassured.response.Response;
import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.Assert;
import utils.ExtentReportListner;

public class ApiVerification extends ExtentReportListner {

    public static boolean responseCodeVerification(Response response, int statusCode){
        boolean resultOfStatusCode = false;
        try {
            Assert.assertEquals(statusCode,response.getStatusCode());
            test.log(LogStatus.PASS,"The status code is true. The status code is: "+ response.getStatusCode());
            resultOfStatusCode = false;
        }
        catch (Exception e){
            test.log(LogStatus.FAIL,e.fillInStackTrace());
        }
        return resultOfStatusCode;
    }

    public static void responseTimeValidation(Response response) {
        try {
            long time=response.time();
            test.log(LogStatus.INFO, "Api response time is :: " + time);
        } catch (Exception e) {
            test.log(LogStatus.FAIL, e.fillInStackTrace());
        }
    }

    public static void responseKeyValidationfromJSONArray(Response response, String key) {
        try {
            JSONArray array = new JSONArray(response.getBody().asString());
            for(int i=0; i<array.length();i++) {
                JSONObject obj = array.getJSONObject(i);
                test.log(LogStatus.PASS, "Validetd values are  " + obj.get(key));

            }
        } catch (Exception e) {
            test.log(LogStatus.FAIL, e.fillInStackTrace());
        }
    }


    public static void responseKeyValidationfromJSONObject(Response response, String key) {
        try {
            JSONObject json = new JSONObject(response.getBody().asString());
            if(json.has(key) && json.get(key)!= null) {
                System.out.println(json.get(key));
                test.log(LogStatus.PASS, "Sucessfully validated value of " + key + " It is " + json.get(key));
            }else {
                test.log(LogStatus.FAIL,"Key is not availble");
            }
        } catch (Exception e) {
            test.log(LogStatus.FAIL, e.fillInStackTrace());
        }
    }
}
