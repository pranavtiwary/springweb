package com.viseo.controller;

import java.util.Map;

import com.viseo.service.ViseoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ViseoController {

    @Autowired
    private final ViseoService service;

    @Autowired
    public ViseoController(ViseoService service) {
        this.service = service;
    }

    @GetMapping(value = "/")
    public String index(Map<String, Object> model) {
        model.put("cronaCount", service.getCronaCountWorld());
        return "index";
    }

    @RequestMapping(value = "/{country}", method = RequestMethod.GET)
    public ModelAndView hello(@PathVariable("country") String country) {
        ModelAndView model = new ModelAndView();
        model.setViewName("country");
        model.addObject("cronaCount", service.getCronaCountByCountry(country));
        model.addObject("country", country);
        return model;
    }

}