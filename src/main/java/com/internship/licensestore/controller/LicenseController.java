package com.internship.licensestore.controller;

import com.internship.licensestore.model.ClientEntity;
import com.internship.licensestore.model.LicenseEntity;
import com.internship.licensestore.service.LicenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;
import java.util.Map;

@Controller
public class LicenseController {

    @Autowired
    private LicenseService service;

    @GetMapping ("/save")
    public void saveLicense (@RequestParam(name = "licenseCreateDate", required = false) String date,
                      @RequestParam(name = "licensePrice", required = false) Integer price
                      /*@RequestParam(name = "licenseClientID", required = false)ClientEntity clientEntity*/) {
        LicenseEntity entity = new LicenseEntity();
        if (date != null) {
            entity.setCreate_date(LocalDate.parse(date));
        }
        if (price != null) {
            entity.setPrice(price);
        }
        //entity.setClientEntity(clientEntity);
        /*entity.setCreate_date(LocalDate.parse("2019-12-22"));
        entity.setPrice(4000);*/
        service.saveLicense(entity);
    }

    @GetMapping ("/")
    public ModelAndView all (Map<String, Object> model) {
        model.put("licenses", service.getAll());
        return new ModelAndView("index", model);
    }
}
