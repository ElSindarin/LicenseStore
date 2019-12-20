package com.internship.persistence.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import com.internship.persistence.model.LicenseEntity;
import com.internship.persistence.util.HibernateSessionFactoryUtil;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.Collection;

public class LicenseDaoImpl implements LicenseDao {

    private static LicenseDaoImpl licenseDao;

    private LicenseDaoImpl() {
    }

    public static synchronized LicenseDao getLicenseDao () {
        if (licenseDao == null) {
            licenseDao = new LicenseDaoImpl();
        }
        return licenseDao;
    }

    @Override
    public void save(LicenseEntity entity) {
        Transaction transaction = null;
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(entity);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }

    @Override
    public Collection<LicenseEntity> getAll() {
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<LicenseEntity> query = cb.createQuery(LicenseEntity.class);
            Root<LicenseEntity> root = query.from(LicenseEntity.class);
            query = query.select(root);
            return session.createQuery(query).getResultList();
        }
    }
}
