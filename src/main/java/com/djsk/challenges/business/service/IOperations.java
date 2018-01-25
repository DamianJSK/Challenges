package com.djsk.challenges.business.service;

import org.springframework.data.domain.Page;

import java.io.Serializable;
import java.util.List;

public interface IOperations<T, I extends Serializable> {

    //I - id
    T findOne(final I id);

    List<T> findAll();

    Page<T> findPaginated(int page, int size);

    T create(final T entity);

    T update(final T entity);

    void refresh(final T entity);

    void delete(final T entity);

    void deleteById(final I entityId);
}
