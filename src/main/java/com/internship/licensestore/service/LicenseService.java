package com.internship.licensestore.service;

import com.internship.licensestore.model.LicenseEntity;

import java.util.Collection;

public interface LicenseService {
    void saveLicense (LicenseEntity entity);
    Collection<LicenseEntity> getAll ();
}
