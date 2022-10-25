package reqresApiTest;

import apiBuilders.PostApiBuilder;
import apiConfigs.APIPath;
import apiConfigs.HeadConfigs;
import baseTest.BaseTest;
import io.restassured.RestAssured;
import io.restassured.config.HeaderConfig;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import pojo.PostApiPojo;

import java.util.Random;

public class PostApiTest extends BaseTest {

    @Test
    public void validPostApiTest(){
        HeadConfigs headerConfig = new HeadConfigs();
        PostApiBuilder postApiBuilder = new PostApiBuilder();

        Response response = RestAssured.given().when().headers(headerConfig.defaultHeaders()).body(postApiBuilder.postRequestBody())
                .when().post(APIPath.apiPath.CREATE_USER);
        System.out.println(response.getBody().asString());
        System.out.println(response.getStatusCode());
    }

    @Test
    public void validPostApiTestWithSerialization(){
        HeadConfigs headerConfig = new HeadConfigs();
        PostApiPojo postApiPojo = new PostApiPojo("Test001","Job001");

        System.out.println("Pojo to string"+ postApiPojo);
        Response response = RestAssured.given().when().headers(headerConfig.defaultHeaders()).body(postApiPojo)
                .when().post(APIPath.apiPath.CREATE_USER);

        System.out.println(response.getBody().asString());

    }
}
