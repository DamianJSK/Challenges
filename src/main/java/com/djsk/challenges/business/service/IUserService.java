package com.djsk.challenges.business.service;

import com.djsk.challenges.persistence.dto.UserDto;
import com.djsk.challenges.persistence.entity.User;

public interface IUserService extends IOperations<User, String>{
    User createUserFromUserDto(UserDto userDto);

    User getCurrentUser();
}
