/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.client.home.service;

import com.client.common.BaseRestTemplate;
import com.client.common.payload.ServiceResponse;
import com.client.home.model.GetSchoolSuggestionResponse;
import com.client.home.model.GetTeacherCountResponse;
import com.client.home.model.GetTeacherSuggestionRequest;
import com.client.home.model.GetTeacherSuggestionResponse;
import com.client.home.model.RateTeacherRequest;
import com.client.home.model.SearchRateRequest;
import com.client.home.model.SearchRateResponse;
import com.google.gson.Gson;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/**
 *
 * @author hossainul
 */
@Service
public class HomeService extends BaseRestTemplate{
    
    
    
    public GetSchoolSuggestionResponse searchSuggestion(String query) throws Exception{        
        String url= getUrl() + "/api/school/suggestion/"+query;
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.add("Authorization", "Bearer " + getToken());
        HttpEntity<String> entity = new HttpEntity<>(headers);
        
        ResponseEntity<GetSchoolSuggestionResponse> response = restTemplate.exchange(url,
        HttpMethod.GET,entity, new ParameterizedTypeReference<GetSchoolSuggestionResponse>() {});
        return response.getBody(); 
    }
    
    public GetTeacherCountResponse getTeacherCount(String schoolName) throws Exception{        
        String url= getUrl() + "/api/school/teacher-count/"+schoolName;
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.add("Authorization", "Bearer " + getToken());
        HttpEntity<String> entity = new HttpEntity<>(headers);
        
        ResponseEntity<GetTeacherCountResponse> response = restTemplate.exchange(url,
        HttpMethod.GET,entity, new ParameterizedTypeReference<GetTeacherCountResponse>() {});
        return response.getBody(); 
    }
    
    public GetTeacherSuggestionResponse getTeacherSuggestion(GetTeacherSuggestionRequest request) throws Exception{        
        GetTeacherSuggestionResponse resp;
        String url= getUrl() + "/api/school/teacher-suggestion";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.add("Authorization", "Bearer " + getToken());
        
        Gson gson = new Gson();
        String entityStr = gson.toJson(request);
        
        HttpEntity<String> entity = new HttpEntity<>(entityStr, headers);
        
        resp = restTemplate.postForObject(url, entity, GetTeacherSuggestionResponse.class);
        return resp;
    }
    
    public ServiceResponse rateTeacher(RateTeacherRequest request) throws Exception{        
        ServiceResponse resp;
        String url= getUrl() + "/api/school/rate-teacher";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.add("Authorization", "Bearer " + getToken());
        
        Gson gson = new Gson();
        String entityStr = gson.toJson(request);
        
        HttpEntity<String> entity = new HttpEntity<>(entityStr, headers);
        
        resp = restTemplate.postForObject(url, entity, ServiceResponse.class);
        return resp;
    }
    
    public SearchRateResponse searchRate(SearchRateRequest request) throws Exception{        
        SearchRateResponse resp;
        String url= getUrl() + "/api/school/search-rate";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.add("Authorization", "Bearer " + getToken());
        
        Gson gson = new Gson();
        String entityStr = gson.toJson(request);
        
        HttpEntity<String> entity = new HttpEntity<>(entityStr, headers);
        
        resp = restTemplate.postForObject(url, entity, SearchRateResponse.class);
        return resp;
    }
    
}
