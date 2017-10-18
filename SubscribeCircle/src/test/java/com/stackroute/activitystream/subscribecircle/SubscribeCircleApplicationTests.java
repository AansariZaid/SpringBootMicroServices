package com.stackroute.activitystream.subscribecircle;

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
public class SubscribeCircleApplicationTests {


	@Autowired
	SubscribeDAO subscribeDAO;

	@BeforeClass
	public static void init() {
	}

//	@Test
	public void subscribeTest() {
		assertEquals(true, subscribeDAO.subscribeCircle(1, "zaid3891@gmail.com"));
	}

	@Test
	public void unSubscribeTest() {
		assertEquals(true, subscribeDAO.unSubscribeCircle(1, "zaid3891@gmail.com"));
	}


}
