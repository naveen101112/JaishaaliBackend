package com.techgeeknext.service;

import com.techgeeknext.bean.TokensBean;
import com.techgeeknext.entity.InvalidTokenDAO;
import com.techgeeknext.entity.LoginDao;
import com.techgeeknext.model.LoginDto;
import com.techgeeknext.repository.InvalidToken;
import com.techgeeknext.repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;

@Service
public class LoginService implements UserDetailsService {
	@Autowired
	private LoginRepository userDao;
	@Autowired
	private InvalidToken invalidateToken;

	@Autowired
	private PasswordEncoder bcryptEncoder;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		LoginDao user = userDao.findByUsername(username);
		if (user == null) {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
		System.out.println("In jwt service loadUserByUsername:"+user.getUsername()+ user.getPassword());
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
				new ArrayList<>());
	}

	public LoginDao save(LoginDto user) {
		LoginDao newUser = new LoginDao();
		newUser.setUsername(user.getUsername());
		newUser.setPassword(bcryptEncoder.encode(user.getPassword()));
		return userDao.save(newUser);
	}
	
	public LoginDao updatePassword(LoginDto user) {
		LoginDao newUser = new LoginDao();
		newUser.setId(userDao.findByUsername(user.getUsername()).getId());
		newUser.setUsername(user.getUsername());
		newUser.setPassword(bcryptEncoder.encode(user.getPassword()));
		return userDao.save(newUser);
	}
	
	public boolean userExist(String username) {
		return userDao.existsByUsername(username);
	}
	
	public InvalidTokenDAO logoutSession1(String token) {
		InvalidTokenDAO tk=new InvalidTokenDAO();
		tk.setToken(token);
		return invalidateToken.save(tk);
	}
	
	public String logoutSession(String token) {
		TokensBean tokens=TokensBean.getInstance();
		tokens.addToken(token);
		return "Success";
	}
	
}