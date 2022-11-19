/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.client.home.controller;

import com.client.home.model.GetSchoolSuggestionResponse;
import com.client.home.model.GetTeacherCountResponse;
import com.client.home.model.GetTeacherSuggestionRequest;
import com.client.home.model.GetTeacherSuggestionResponse;
import com.client.home.model.Rate;
import com.client.home.model.RateTeacherRequest;
import com.client.home.model.SchoolData;
import com.client.home.model.SchoolSuggestion;
import com.client.home.model.SearchRateRequest;
import com.client.home.model.SearchRateResponse;
import com.client.home.model.SmallTeacher;
import com.client.home.service.HomeService;
import com.client.util.Utils;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
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
            if (!Utils.isOk(schoolName) && Utils.isOk(query)) {
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
    public ModelAndView teacher(HttpServletRequest req, @RequestParam("schoolName") String schoolName) {

        ModelAndView mv = new ModelAndView("home/teacher-search");
        mv.addObject("schoolName", schoolName);
        return mv;
    }

    @GetMapping("teacher-autoComplete")
    public ResponseEntity<?> teacherAutocomplete(@RequestParam("schoolName") String schoolName, @RequestParam("query") String query) {
        List<SmallTeacher> dataList = new ArrayList<>();
        try {
            GetTeacherSuggestionRequest request = new GetTeacherSuggestionRequest();
            request.setSchoolName(schoolName);
            request.setTeacherName(query);
            GetTeacherSuggestionResponse resp = service.getTeacherSuggestion(request);
            if (resp != null && resp.getSuggestions() != null) {
                dataList = resp.getSuggestions();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return ResponseEntity.ok(dataList);
    }

    @GetMapping("search-teacher")
    public ModelAndView searchTeacher(@RequestParam("schoolName") String schoolName) {
        ModelAndView mv = new ModelAndView("home/search-teacher");

        mv.addObject("schoolName", schoolName);
        return mv;
    }

    @PostMapping("search-teacher")
    public ModelAndView postSearch(@ModelAttribute("searchRateRequest") SearchRateRequest searchRateRequest) {
        ModelAndView mv = new ModelAndView("home/list-teacher");
        List<SchoolData> schools = new ArrayList<>();
        try {
            searchRateRequest.setFrom(0);
            searchRateRequest.setSize(12);
            SearchRateResponse resp = service.searchRate(searchRateRequest);
            if (resp != null) {
                schools = resp.getDataList();
                for (SchoolData sd : schools) {
                    Integer totalRate = 0;
                    if (sd.getRates() != null) {
                        for (Rate r : sd.getRates()) {
                            if(r.getRate() != null){
                                totalRate += r.getRate().intValue();
                            }
                        }
                        sd.setRate(totalRate/sd.getRates().size());
                    }
                    
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        mv.addObject("schools", schools);
        mv.addObject("request", searchRateRequest);
        return mv;
    }

    @GetMapping("rate-teacher")
    public ModelAndView rateTeacher(@RequestParam("teacherName") String teacherName, @RequestParam("schoolName") String schoolName, @RequestParam("teacherId") String teacherId) {
        ModelAndView mv = new ModelAndView("home/rate-teacher");

        mv.addObject("teacherName", teacherName);
        mv.addObject("schoolName", schoolName);
        mv.addObject("teacherId", teacherId);
        return mv;
    }

    @PostMapping("rate-teacher")
    public ModelAndView rate(@ModelAttribute("rate") RateTeacherRequest rate, HttpServletRequest req) {
        ModelAndView mv = new ModelAndView("home/rate-teacher");
        try {
            service.rateTeacher(rate);
        } catch (Exception ex) {

        }
        String teacherName = req.getParameter("teacherName");
        String schoolName = req.getParameter("schoolName");
        String teacherId = req.getParameter("teacherId");
        mv.addObject("teacherName", teacherName);
        mv.addObject("schoolName", schoolName);
        mv.addObject("teacherId", teacherId);
        mv.addObject("msg", "Rating Done!");
        return mv;
    }
}
