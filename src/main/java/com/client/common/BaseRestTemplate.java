/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.client.common;


import com.client.common.payload.TokenRequest;
import com.client.common.payload.TokenResponse;
import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * @author hossain
 */
@Component
@PropertySources({
        @PropertySource("classpath:application.properties")})
public class BaseRestTemplate {

    @Autowired
    private Environment env;
    
    @Autowired
    protected RestTemplate restTemplate;
    

    private static String PROTOCOL;


    public static String HOST;


    public static String PORT;

    public static String PATH = "api";

    private static String SERVICE_URL = "";

    private static String FIELD_ATTACHMENT_URL = "";
    
    private String token;


    @PostConstruct
    void init() {

        PROTOCOL = env.getProperty("api.service.protocol");
        HOST = env.getProperty("api.service.host");
        PORT = env.getProperty("api.service.port");
        PATH = env.getProperty("api.service.context");
        FIELD_ATTACHMENT_URL = env.getProperty("fv.attachment.url");

        if (PORT != null && PORT.length() > 0) {
            SERVICE_URL = PROTOCOL + "://" + HOST + ":" + PORT + "/" + PATH + "/";
        } else {
            SERVICE_URL = PROTOCOL + "://" + HOST + "/" + PATH + "/";
        }
        try{
            login();
        }catch(Exception ex){ex.printStackTrace();}
    }

    public static String getUrl() {
        return SERVICE_URL;
    }

    public static String getFieldAttachmentUrl() {
        return FIELD_ATTACHMENT_URL;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    private void login() throws Exception{
        String userName = "admin";
        String password = "Abc@1234.";
        TokenResponse tr = new TokenResponse();
        TokenRequest tokenRequest = new TokenRequest();
        tokenRequest.setPassword(password);
        tokenRequest.setUserName(userName);
        String url= getUrl() + "/api/auth/signin";
        tr = restTemplate.postForObject(url, tokenRequest, TokenResponse.class);
        tr.setUserId(1);
        tr.setRole("ADMIN");
        this.setToken(tr.getToken());
    }

}
