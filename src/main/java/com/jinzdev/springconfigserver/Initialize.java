package com.jinzdev.springconfigserver;


import com.fasterxml.jackson.core.JsonParseException;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Created by JinzDev on 04/15/2018
 * Initialize configuration from config file
 */
@Configuration
public class Initialize {

    public static AppConfig appConfig;
    public static String configFile;

    @Autowired
    public Initialize(Environment env){
        this.configFile = env.getProperty("app.config-file");
        init(configFile);
    }

    public static void init(String configFile){
        try {
            System.out.println("Config path:: " + configFile);
            FileInputStream inputStream = new FileInputStream(configFile);
            String content = IOUtils.toString(inputStream);
            appConfig = new Gson().fromJson(content, AppConfig.class);
        }
        catch (JsonParseException e){
            System.out.println("Error parsing json plz check json format in file config");
        }
        catch (FileNotFoundException e){
            System.out.println("File config not found - Please check config address config file path");
        }catch (IOException e){
            System.out.println("IO Exception: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void reloadConfig(){
        init(configFile);
    }

    public static AppConfig getAppConfig() {
        return appConfig;
    }

}
