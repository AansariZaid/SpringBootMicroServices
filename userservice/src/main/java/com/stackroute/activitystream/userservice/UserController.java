package com.stackroute.activitystream.userservice;

import java.util.List;

import javax.jws.soap.SOAPBinding.Use;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
	@Autowired
	UserDAO userDAO;

	@Autowired
	HttpSession session;

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ResponseEntity<User> insertUser(@RequestBody User user) {
		try {
			userDAO.register(user);
			user.setStatusMessage("User Registered Sucessfully");
			return new ResponseEntity<>(user, HttpStatus.OK);
		} catch (Exception e) {
			user.setStatusMessage("User Registration Failed");
			return new ResponseEntity<>(user, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ResponseEntity<User> validateUser(@RequestBody User user) {
		try {
			User validUser = userDAO.validate(user);
			if (validUser != null) {
				session.setAttribute("currentUser", validUser);
				return new ResponseEntity<User>(validUser, HttpStatus.OK);
			} else {
				return new ResponseEntity<>(user, HttpStatus.INTERNAL_SERVER_ERROR);
			}
		} catch (Exception e) {
			return new ResponseEntity<>(user, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@RequestMapping(value = "/logout", method = RequestMethod.DELETE)
	public ResponseEntity<?> logoutUser() {
		User user = (User) session.getAttribute("currentUser");
		if (user != null) {
			session.invalidate();
			return new ResponseEntity<Void>(HttpStatus.OK);
		} else {
			return new ResponseEntity<Void>(HttpStatus.UNAUTHORIZED);
		}
	}

	@RequestMapping("/getAllUsers")
	public ResponseEntity<List<User>> getAllUsers() {
		try {
			List<User> allUsers = userDAO.getAllUser();
			return new ResponseEntity<>(allUsers, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
		}
	}

	@RequestMapping("/getUser/{emailid}")
	public ResponseEntity<User> getUser(@PathVariable String emailid) {
		try {
			User user = userDAO.getUser(emailid);
			return new ResponseEntity<User>(user, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
		}
	}
}
