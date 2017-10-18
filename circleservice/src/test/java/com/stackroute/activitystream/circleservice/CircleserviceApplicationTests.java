package com.stackroute.activitystream.circleservice;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.stackroute.activitystream.circleservice.Circle;
import com.stackroute.activitystream.circleservice.CircleDAO;
import com.stackroute.activitystream.circleservice.CircleserviceApplication;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class CircleserviceApplicationTests {

	@Autowired
	private static Circle circle;

	@Autowired
	CircleDAO circleDAO;

	@BeforeClass
	public static void setUp() {
		circle = new Circle();
	}

	@Test
	public void createCircleTest() {
		// circle.setCircleid(4);
		circle.setCircleName("Circle10");
		circle.setDescription("this is first Circle");
		circle.setCircleOwner("zaid3891@gmail.com");
		assertEquals("Circle Created ", true, circleDAO.createCicrcle(circle));
	}

	//@Test
	public void updateCircleTest() {
		circle = circleDAO.getCircleById(1);
		circle.setCircleName("basd");
		assertEquals("Circle Updated", true, circleDAO.updateCircle(circle));
	}

	// @Test
	public void deleteCircleTest() {
		assertEquals("Circle Deleted", true, circleDAO.deleteCircle(4));

	}

	//@Test
	public void getCircleByIdTest() {
		circle = circleDAO.getCircleById(1);
		assertNotNull(circle);
		display(circle);
	}

	/*@Test
	public void getCircleByName() {
		circle = circleDAO.getCircleByName("Circle10");
		assertNotNull(circle);
		display(circle);
	}*/

	@Test
	public void getAllCircles() {
		List<Circle> allCircles = circleDAO.getAllCircles();
		assertNotNull(allCircles);
		for (Circle c : allCircles)
			display(c);
	}

	public void display(Circle circle) {
		System.out.println(circle);
	}

}
