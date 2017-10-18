package com.stackroute.activitystream.circleservice;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CircleController {
	
	@Autowired
	CircleDAO circleDAO;

	@PostMapping("/createCircle")
	public ResponseEntity<?> createCircle(@RequestBody Circle circle) {
		try {
			circleDAO.createCicrcle(circle);
			return new ResponseEntity<Circle>(circle, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("getCircle/{id}")
	public ResponseEntity<Circle> getCircleById(@PathVariable int id) {
		try {
			return new ResponseEntity<Circle>(circleDAO.getCircleById(id), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping(value = "/updatecircle")
	public ResponseEntity<?> updateCircle(@RequestBody Circle circle) {
		try {
			circleDAO.updateCircle(circle);
			return new ResponseEntity<Circle>(circle, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@RequestMapping("deleteCircle/{circleId}")
	public ResponseEntity<?> deleteCircle(@PathVariable int circleId) {
		try {
			circleDAO.deleteCircle(circleId);
			return new ResponseEntity<Void>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@RequestMapping(value = "/getallcircles")
	public ResponseEntity<?> getAllCircles() {
		try {
			List<Circle> allCircles = circleDAO.getAllCircles();
			return new ResponseEntity<List<Circle>>(allCircles, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		}
	}
}
