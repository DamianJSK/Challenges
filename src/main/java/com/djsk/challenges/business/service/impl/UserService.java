package com.djsk.challenges.business.service.impl;

import com.djsk.challenges.business.service.AbstractIOService;
import com.djsk.challenges.business.service.IUserService;
import com.djsk.challenges.persistence.dao.IUserDao;
import com.djsk.challenges.persistence.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService extends AbstractIOService<User, String> implements IUserService{

    @Autowired
    IUserDao userDao;

    @Override
    protected PagingAndSortingRepository getDao() {
        return userDao;
    }
}
