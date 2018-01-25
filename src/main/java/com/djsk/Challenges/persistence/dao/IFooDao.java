package com.djsk.Challenges.persistence.dao;

import com.djsk.Challenges.persistence.entity.Foo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IFooDao extends JpaRepository<Foo, Long > {

    Foo findByName( String name );

}