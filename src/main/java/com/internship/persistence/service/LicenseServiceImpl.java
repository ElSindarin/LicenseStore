package com.internship.persistence.service;

import com.internship.persistence.dao.LicenseDao;
import com.internship.persistence.dao.LicenseDaoImpl;
import com.internship.persistence.model.LicenseEntity;

import java.util.Collection;
import java.util.Collections;

public class LicenseServiceImpl implements LicenseService {

    private LicenseDao licenseDao = LicenseDaoImpl.getLicenseDao();

    @Override
    public void saveLicense(LicenseEntity entity) {
        if (entity == null) {
            throw new IllegalArgumentException("Lincense should be defined");
        }
        licenseDao.save(entity);
    }

    @Override
    public Collection<LicenseEntity> getAll() {
        Collection<LicenseEntity> licenses = licenseDao.getAll();
        return licenses == null || licenses.isEmpty() ? Collections.emptyList() : licenses;
    }
}
