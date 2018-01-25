package com.djsk.Challenges.persistence.dao;

import com.djsk.Challenges.persistence.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserDao extends JpaRepository<User, String> {
}
