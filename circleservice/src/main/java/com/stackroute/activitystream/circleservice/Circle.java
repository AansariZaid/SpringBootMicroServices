package com.stackroute.activitystream.circleservice;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

@Entity
@Component
public class Circle {

	@Id
	@Column
	int Circleid;
	@Column
	String circleName;
	@Column
	String Description;
	@Column
	String circleOwner;
	@Column
	Date creationDate;
	@Column
	String circleStatus;

	public String getCircleOwner() {
		return circleOwner;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCircleOwner(String circleOwner) {
		this.circleOwner = circleOwner;
	}

	public void setCreationDate(Date date) {
		this.creationDate = date;
	}

	public int getCircleid() {
		return Circleid;
	}

	public void setCircleid(int circleid) {
		Circleid = circleid;
	}

	public String getCircleName() {
		return circleName;
	}

	public String getDescription() {
		return Description;
	}

	public void setCircleName(String circleName) {
		this.circleName = circleName;
	}

	public void setDescription(String description) {
		Description = description;
	}

	@Override
	public String toString() {
		return "Circle [Circleid=" + Circleid + ", circleName=" + circleName + ", Description=" + Description
				+ ", circleOwner=" + circleOwner + ", creationDate=" + creationDate + "]";
	}

	public String getCircleStatus() {
		return circleStatus;
	}

	public void setCircleStatus(String circleStatus) {
		this.circleStatus = circleStatus;
	}

}
