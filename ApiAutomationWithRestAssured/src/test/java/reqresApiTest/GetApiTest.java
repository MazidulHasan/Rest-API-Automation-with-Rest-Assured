package reqresApiTest;

import apiConfigs.APIPath;
import apiVerifications.ApiVerification;
import baseTest.BaseTest;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import pojo.AllUsers;
import pojo.Datum;
import pojo.SingleUser;
import pojo.Data;

import java.util.List;

import static io.restassured.RestAssured.given;

public class GetApiTest extends BaseTest {

    @Test
    public void getAllApiTest(){
//        RestAssured.given().when().get(APIPath.apiPath.GET_LIST_OF_USERS).then().log().all().statusCode(200);
        Response response = given().when().get(APIPath.apiPath.GET_LIST_OF_USERS);
        if(ApiVerification.responseCodeVerification(response,200)){
            ApiVerification.responseKeyValidationfromJSONObject(response,"page");
        }
    }

    @Test
    public void getWithDeserialization(){
//        Response response= RestAssured.given().when().get(APIPath.apiPath.GET_LIST_OF_USERS);
        SingleUser singleUser = given().when().get(APIPath.apiPath.GET_SINGLE_USER).as(SingleUser.class);
        Data data = singleUser.getData();
        System.out.println("Name is: "+data.getFirstName());
        System.out.println("Email is: "+ singleUser.getData().getEmail());
    }

    @Test
    public void getAllUsersWithDeserialization(){
//        Response response= RestAssured.given().when().get(APIPath.apiPath.GET_LIST_OF_USERS);
        AllUsers allUsers = given().when().get(APIPath.apiPath.GET_LIST_OF_USERS).as(AllUsers.class);
        List<Datum> datum = allUsers.getData();
        for (int i =0; i<datum.size();i++){
            System.out.println("The data is "+ datum.get(i));
        }
    }


}
