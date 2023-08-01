package com.springbootdatabse.database;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryClass extends JpaRepository<Bean, Integer> {

	//public List<Bean> findBeanByUsername(String username,String password);

}
