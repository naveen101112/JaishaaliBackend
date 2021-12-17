package com.techgeeknext.service;

import com.techgeeknext.bean.TokensBean;
import com.techgeeknext.entity.InvalidTokenDAO;
import com.techgeeknext.entity.LoginDao;
import com.techgeeknext.entity.UserDao;
import com.techgeeknext.model.LoginDto;
import com.techgeeknext.model.UserDto;
import com.techgeeknext.repository.InvalidToken;
import com.techgeeknext.repository.LoginRepository;
import com.techgeeknext.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.Optional;

@Service
public class UserService {
	@Autowired
	private UserRepository userDao;
	@Autowired
	private InvalidToken invalidateToken;

	@Autowired
	private PasswordEncoder bcryptEncoder;

	public UserDao save(UserDto user) {
		UserDao newUser = new UserDao();
		newUser.setFname(user.getFname());
		newUser.setLname(user.getLname());
		newUser.setAddress(user.getAddress());
		newUser.setPhone(user.getPhone());
		newUser.setPincode(user.getPincode());
		newUser.setState(user.getState());
		return userDao.save(newUser);
	}
	
	public Optional<UserDao> getDetails(long id) {
		return userDao.findById(id);
	}
	
	public Iterable<UserDao> getAllUsers() {
		return userDao.findAll();
	}
	
	public UserDao update(UserDto user) {
		UserDao newUser = new UserDao();
		newUser.setId(user.getId());
		newUser.setFname(user.getFname());
		newUser.setLname(user.getLname());
		newUser.setAddress(user.getAddress());
		newUser.setPhone(user.getPhone());
		newUser.setPincode(user.getPincode());
		newUser.setState(user.getState());
		return userDao.save(newUser);
	}
	
	@Transactional
	public void delete(long id) {
		userDao.deleteById(id);
	}
	
	public boolean userExist(String username) {
		return true;//return userDao.existsByUsername(username);
	}
	
}