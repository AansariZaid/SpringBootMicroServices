package com.stackroute.activitystream.userservice;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class UserTest {

	private static User user;

	@Autowired
	UserDAO userDAO;

	@BeforeClass
	public static void init() {
		user = new User();
	}

	@Test
	public void registerTest() {
		user.setPhoneNumber("9022484348");
		user.setEmailid("ansari.zaid1@");
		user.setFirstName("Ansari1");
		user.setLastName("Ansari");
		user.setPassword("zaid@123");
		user.setStatus("A");
		assertEquals("User Registered Sucessfully", true, userDAO.register(user));
	}

	// @Test
	public void updateTest() {
		user.setPhoneNumber("9022484348");
		user.setFirstName("Aansari");
		user.setLastName("Zaid");
		user.setEmailid("ansari.zaid1@niit.com");
		user.setPassword("zaid@123");
		user.setStatus("A");
		assertEquals("User Updated Sucessfully", true, userDAO.Update(user));
	}

	// @Test
	public void validateTest() {
		user.setEmailid("zaid@gmial.com");
		user.setPassword("zaid@123");
		assertEquals("User Validated", User.class, userDAO.validate(user).getClass());

	}

	// @Test
	public void deleteTest() {
		user.setEmailid("ansari.zaid1@niit.com");
		assertEquals("User Deleted ", true, userDAO.delete(user.getEmailid()));
	}

}
