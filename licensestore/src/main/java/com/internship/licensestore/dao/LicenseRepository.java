package com.internship.licensestore.dao;

import com.internship.licensestore.model.LicenseEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LicenseRepository extends JpaRepository<LicenseEntity, Integer> {
}
