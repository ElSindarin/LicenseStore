package com.internship.licensestore.service;

import com.internship.licensestore.dao.LicenseRepository;
import com.internship.licensestore.model.LicenseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class LicenseServiceImpl implements LicenseService {

    @Autowired
    private LicenseRepository repository;

    @Override
    public void saveLicense(LicenseEntity entity) {

    }

    @Override
    public Collection<LicenseEntity> getAll() {
        return repository.findAll();
    }
}
