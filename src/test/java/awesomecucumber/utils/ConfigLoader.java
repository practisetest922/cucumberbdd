package awesomecucumber.utils;

import awesomecucumber.constants.EnvType;

import java.util.Properties;

public class ConfigLoader {
    private final Properties properties;
    private static ConfigLoader configLoader;

    private ConfigLoader() {
        String env=System.getProperty("env", String.valueOf(EnvType.STAGE));
       switch (EnvType.valueOf(env)){
           case STAGE -> properties=PropertyUtils.propertyLoader("src/test/resources/stage_config.properties");
           case PROD -> properties=PropertyUtils.propertyLoader("src/test/resources/prod_config.properties");
           default -> throw new IllegalStateException("Invalid evn"+env);
       }


    }
    public static ConfigLoader getInstance(){
        if(configLoader==null){
            configLoader=new ConfigLoader();
        }
        return configLoader;
    }

    public String getBaseUrl(){
        String prop=properties.getProperty("baseUrl");
        if(prop!=null) return prop;
        else throw new RuntimeException("property baseurl is not specified in the config file");
    }
}
