package com.internship;

import com.internship.persistence.model.LicenseEntity;
import com.internship.persistence.service.LicenseService;
import com.internship.persistence.service.LicenseServiceImpl;

import java.time.LocalDate;

public class LicenseStore {

    private LicenseService licenseService = new LicenseServiceImpl();

    public static void main(String[] args) {
        LicenseStore app = new LicenseStore();
//        LicenseEntity license = new LicenseEntity();
//        license.setClient("Megan");
//        license.setCreate_date(LocalDate.parse("2019-10-01"));
//        license.setPrice(300);
//        app.licenseService.saveLicense(license);
//        System.out.println(app.licenseService.getAll());
        app.licenseService.getAll().forEach(System.out::println);
    }
}
