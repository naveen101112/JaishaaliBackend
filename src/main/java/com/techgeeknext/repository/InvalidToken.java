package com.techgeeknext.repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.techgeeknext.entity.InvalidTokenDAO;
public interface InvalidToken extends CrudRepository<InvalidTokenDAO, Integer> {
	InvalidTokenDAO findByToken(String jwt);
    boolean existsByToken(String jwt);
}