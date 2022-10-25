package baseTest;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import utils.EnvFiles;
import utils.ExtentReportListner;

import java.beans.ExceptionListener;

@Listeners(ExtentReportListner.class)
public class BaseTest extends ExtentReportListner{
    @BeforeClass
    public void baseTest(){
        RestAssured.baseURI = EnvFiles.envFiles().get("ServerUrl");
    }
}
