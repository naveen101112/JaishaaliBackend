package com.techgeeknext.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.BodyBuilder;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.techgeeknext.config.JwtTokenUtil;
import com.techgeeknext.entity.UserDao;
import com.techgeeknext.model.LoginDto;
import com.techgeeknext.model.UserDto;
import com.techgeeknext.service.LoginService;
import com.techgeeknext.service.UserService;

@RestController()
@RequestMapping("/admin")
@CrossOrigin
public class AdminController {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@Autowired
	private LoginService loginService;
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/user")
	public BodyBuilder saveUser(@RequestBody UserDto user) throws Exception {
		UserDao newUser=userService.save(user);
		return ResponseEntity.created(new URI("/admin/user/"+newUser.getId()));
	}
	
	@PatchMapping("/user")
	public ResponseEntity<?> updateUser(@RequestBody UserDto user) throws Exception {
		return ResponseEntity.ok(userService.update(user));
	}
	
	@GetMapping("/user/{id}")
	public ResponseEntity<?> getUser(@PathVariable long id) throws Exception {
		return ResponseEntity.ok(userService.getDetails(id));
	}
	
	@DeleteMapping("/user/{id}")
	public ResponseEntity<?> deleteUser(@PathVariable long id) throws Exception {
		userService.delete(id);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body("Delete Successful.");
	}
	
	@GetMapping("/user")
	public ResponseEntity<?> getAllUsers(@RequestBody LoginDto user) throws Exception {
		return ResponseEntity.ok(userService.getAllUsers());
	}
}
