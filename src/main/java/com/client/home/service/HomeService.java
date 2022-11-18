/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.client.home.service;

import com.client.common.BaseRestTemplate;
import com.client.home.model.GetSchoolSuggestionResponse;
import com.client.home.model.GetTeacherCountResponse;
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
    
}
