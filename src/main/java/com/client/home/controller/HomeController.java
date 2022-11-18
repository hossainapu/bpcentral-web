/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.client.home.controller;

import com.client.home.model.DataModel;
import com.client.home.model.DataSearchRequest;
import com.client.home.model.DataSearchResponse;
import com.client.home.model.GetSchoolSuggestionResponse;
import com.client.home.model.GetTeacherCountResponse;
import com.client.home.model.SchoolSuggestion;
import com.client.home.service.HomeService;
import com.client.util.Utils;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(path = "/")
public class HomeController {

    @Autowired
    HomeService service;

    @GetMapping
    public ModelAndView home(HttpServletRequest req) {

        ModelAndView mv = new ModelAndView("home/home");   
        return mv;
    }
    
    @GetMapping("school-autoComplete")
    public ResponseEntity<?> schoolAutocomplete(@RequestParam("query") String query) {
        List<SchoolSuggestion> dataList = new ArrayList<>();
        try {
            
            GetSchoolSuggestionResponse resp = service.searchSuggestion(query);
            if (resp != null && resp.getSuggestions() != null) {
                dataList = resp.getSuggestions();
            }
        } catch (Exception ex) {

        }
        return ResponseEntity.ok(dataList);
    }
    
    @GetMapping("search-school")
    public ModelAndView search(@RequestParam("schoolName") String schoolName, @RequestParam("query") String query) {
        ModelAndView mv = new ModelAndView("home/count");
        Long count = 0L;
        try {
            if(!Utils.isOk(schoolName) && Utils.isOk(query)){
                schoolName = query;
            }
            GetTeacherCountResponse resp = service.getTeacherCount(schoolName);
            if (resp != null) {
                count = resp.getCount();
            }
        } catch (Exception ex) {

        }
        mv.addObject("schoolName", schoolName);
        mv.addObject("count", count);
        return mv;
    }
    
    @GetMapping("teacher")
    public ModelAndView teacher(HttpServletRequest req) {

        ModelAndView mv = new ModelAndView("home/teacher-search");   
        return mv;
    }
    
    @GetMapping("teacher-autoComplete")
    public ResponseEntity<?> teacherAutocomplete(@RequestParam("query") String query) {
        List<SchoolSuggestion> dataList = new ArrayList<>();
        try {
            
            GetSchoolSuggestionResponse resp = service.searchSuggestion(query);
            if (resp != null && resp.getSuggestions() != null) {
                dataList = resp.getSuggestions();
            }
        } catch (Exception ex) {

        }
        return ResponseEntity.ok(dataList);
    }
    
    @GetMapping("search-teacher")
    public ModelAndView searchTeacher(@RequestParam("teacherName") String teacherName, @RequestParam("query") String query) {
        ModelAndView mv = new ModelAndView("home/count");
        Long count = 0L;
        try {
            if(!Utils.isOk(teacherName) && Utils.isOk(query)){
                teacherName = query;
            }
            GetTeacherCountResponse resp = service.getTeacherCount(teacherName);
            if (resp != null) {
                count = resp.getCount();
            }
        } catch (Exception ex) {

        }
        mv.addObject("teacherName", teacherName);
        mv.addObject("count", count);
        return mv;
    }
}
