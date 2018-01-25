package com.djsk.challenges.persistence.dao;

import com.djsk.challenges.persistence.entity.Foo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IFooDao extends JpaRepository<Foo, Long > {

    Foo findByName( String name );

}