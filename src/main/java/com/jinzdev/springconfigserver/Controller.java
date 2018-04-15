package com.jinzdev.springconfigserver;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/config")
public class Controller {

    @GetMapping
    public String getAppConfig(){
        String appConfig = new Gson().toJson(Initialize.getAppConfig(), AppConfig.class);
       return appConfig;
    }

    @PostMapping
    public String reloadConfig(){
        Initialize.reloadConfig();
        String appConfig = new Gson().toJson(Initialize.getAppConfig(), AppConfig.class);
        return appConfig;
    }
}
