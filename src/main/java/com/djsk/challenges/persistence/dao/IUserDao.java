package com.djsk.challenges.persistence.dao;

import com.djsk.challenges.persistence.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserDao extends JpaRepository<User, String> {
}
