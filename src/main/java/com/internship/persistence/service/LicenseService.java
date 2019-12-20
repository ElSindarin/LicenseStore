package com.internship.persistence.service;

import com.internship.persistence.model.LicenseEntity;

import java.util.Collection;

public interface LicenseService {
    void saveLicense (LicenseEntity entity);
    Collection<LicenseEntity> getAll ();
}
