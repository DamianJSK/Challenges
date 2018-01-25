package com.djsk.Challenges.business.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractIOService<T, I extends Serializable> implements IOperations<T, I> {

    @Autowired
    EntityManager entityManager;

    @Override
    @Transactional(readOnly = true)
    public T findOne(I id) {
        return getDao().findOne(id);
    }

    @Transactional(readOnly = true)
    @Override
    public List<T> findAll() {
        List<T> target = new ArrayList<>();
        (getDao().findAll()).forEach(target::add);
        return target;
    }

    @Transactional
    @Override
    public Page<T> findPaginated(final int page, final int size) {
        return getDao().findAll(new PageRequest(page, size));
    }

    @Transactional
    @Override
    public T create(final T entity) {
        return getDao().save(entity);
    }

    @Transactional
    @Override
    public T update(final T entity) {
        return getDao().save(entity);
    }

    @Transactional
    @Override
    public void refresh(final T entity) {
        entityManager.refresh(entity);
    }

    @Transactional
    @Override
    public void delete(final T entity) {
        getDao().delete(entity);
    }

    @Transactional
    @Override
    public void deleteById(final I entityId) {
        getDao().delete(entityId);
    }

    @Transactional
    protected abstract PagingAndSortingRepository<T,I> getDao();
}
