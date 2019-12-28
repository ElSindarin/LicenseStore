package com.internship.licensestore.controller;

import com.internship.licensestore.model.LicenseEntity;
import com.internship.licensestore.service.LicenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
public class LicenseRestController {

    @Autowired
    private LicenseService licenseService;

    @GetMapping (value = "/all")
    public Collection<LicenseEntity> getAll() {
        return licenseService.getAll();
    }

}
