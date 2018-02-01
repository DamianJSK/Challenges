package com.djsk.challenges.business.service.impl;

import com.djsk.challenges.business.service.AbstractIOService;
import com.djsk.challenges.business.service.IUserService;
import com.djsk.challenges.persistence.dao.IUserDao;
import com.djsk.challenges.persistence.dto.UserDto;
import com.djsk.challenges.persistence.entity.User;
import com.djsk.challenges.web.exception.EmailExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class UserService extends AbstractIOService<User, String> implements IUserService{

    @Autowired
    IUserDao userDao;

    @Override
    protected PagingAndSortingRepository getDao() {
        return userDao;
    }

    @Transactional
    @Override
    public User createUserFromUserDto(UserDto userDto) throws EmailExistsException {

            if (emailExist(userDto.getEmail())) {
                //Should return additional info with custom message
                throw new EmailExistsException("There is an account with that email adress: " + userDto.getEmail());
            }
            User newUser = new User();
            newUser.setName(userDto.getName());
            newUser.setEmail(userDto.getEmail());
            newUser.setPassword(userDto.getPassword());
            //there should be also assigned user role
//        user.setRoles(Arrays.asList("ROLE_USER"));
            return create(newUser);
    }

    private boolean emailExist(String email) {
        User user = userDao.findByEmail(email);
        if (user != null) {
            return true;
        }
        return false;
    }
}
