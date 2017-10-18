package com.stackroute.activitystream.circleservice;

import java.util.List;

public interface CircleDAO {
	
	Boolean createCicrcle(Circle circle);
	Boolean updateCircle(Circle circle);
	Boolean deleteCircle(int circleId);
	Circle getCircleById(int circleId);
	//Circle getCircleByName(String name);
	List<Circle> getAllCircles();
	
}
