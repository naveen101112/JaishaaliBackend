package com.techgeeknext.repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.techgeeknext.entity.LoginDao;
public interface LoginRepository extends CrudRepository<LoginDao, Integer> {
    LoginDao findByUsername(String username);
    boolean existsByUsername(String username);
}