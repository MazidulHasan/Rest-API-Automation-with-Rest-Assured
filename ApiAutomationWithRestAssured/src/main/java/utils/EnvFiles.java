package utils;

import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class EnvFiles {
    public static Map<String,String> envFile = new HashMap<String,String>();
    public static Properties properties = new Properties();

    public static Map<String,String> envFiles(){
//        String environment = System.getProperty("env");
        String environment = "local"; // Need to get data from a doc

        try {
            if (environment.equalsIgnoreCase("local")){
                FileInputStream fileInputStreamLocal = new FileInputStream(System.getProperty("user.dir")+ "/runnableEnvironments/local.properties");
                properties.load(fileInputStreamLocal);
                envFile.put("ServerUrl",properties.getProperty("ServerUrl"));
                envFile.put("portNo",properties.getProperty("portNo"));
                envFile.put("userName",properties.getProperty("userName"));
                envFile.put("password",properties.getProperty("password"));
            }
            else if (environment.equalsIgnoreCase("dev")){
                FileInputStream fileInputStreamDev = new FileInputStream(System.getProperty("user.dir")+ "/runnableEnvironments/dev.properties");
                properties.load(fileInputStreamDev);
                envFile.put("ServerUrl",properties.getProperty("ServerUrl"));
                envFile.put("portNo",properties.getProperty("portNo"));
                envFile.put("userName",properties.getProperty("userName"));
                envFile.put("password",properties.getProperty("password"));
            }
            else if (environment.equalsIgnoreCase("prod")){
                FileInputStream fileInputStreamProd = new FileInputStream(System.getProperty("user.dir")+ "/runnableEnvironments/prod.properties");
                properties.load(fileInputStreamProd);
                envFile.put("ServerUrl",properties.getProperty("ServerUrl"));
                envFile.put("portNo",properties.getProperty("portNo"));
                envFile.put("userName",properties.getProperty("userName"));
                envFile.put("password",properties.getProperty("password"));
            }
        }
        catch (Exception e){
            System.out.println("Exception caught in EnvFiles and the exception is : "+ e);
        }
        return envFile;
    }

    public static Map<String,String> getConfigReader(){
        if (envFile == null){
            envFile = envFiles();
        }
        return envFile;
    }

}