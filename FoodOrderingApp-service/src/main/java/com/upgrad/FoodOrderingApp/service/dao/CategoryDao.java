package com.upgrad.FoodOrderingApp.service.dao;

import com.upgrad.FoodOrderingApp.service.entity.CategoryEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class CategoryDao {

    @PersistenceContext
    private EntityManager entityManager;


    public List<CategoryEntity> getCategories() {
        try {
            return entityManager.createNamedQuery("allCategory", CategoryEntity.class)
                    .getResultList();
        } catch(NoResultException nre) {
            return null;
        }

    }

    public List<CategoryEntity> getCategoriesById(String categoryId) {
        try {
            return entityManager.createNamedQuery("categoryById", CategoryEntity.class)
                    .setParameter(1,categoryId)
                    .getResultList();
        } catch(NoResultException nre) {
            return null;
        }

    }
}
