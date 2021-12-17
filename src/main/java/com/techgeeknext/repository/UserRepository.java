package com.techgeeknext.repository;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.techgeeknext.entity.UserDao;
public interface UserRepository extends CrudRepository<UserDao, Integer> {

	Optional<UserDao> findById(long id);

	void deleteById(long id);
}