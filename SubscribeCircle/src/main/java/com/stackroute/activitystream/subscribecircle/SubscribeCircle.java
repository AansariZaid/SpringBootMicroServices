package com.stackroute.activitystream.subscribecircle;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

@Component
@Entity
public class SubscribeCircle {
	@Id
	@Column
	int subscriptionId;

	@Column
	int circleId;

	@Column
	String emailId;

	@Column
	String status;

	@Column
	Date subcriptionDate;

	public int getSubscriptionId() {
		return subscriptionId;
	}

	public int getCircleId() {
		return circleId;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setSubscriptionId(int subscriptionId) {
		this.subscriptionId = subscriptionId;
	}

	public void setCircleId(int circleId) {
		this.circleId = circleId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getStatus() {
		return status;
	}

	public Date getSubcriptionDate() {
		return subcriptionDate;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setSubcriptionDate(Date subcriptionDate) {
		this.subcriptionDate = subcriptionDate;
	}

	@Override
	public String toString() {
		return "SubscribeCircle [subscriptionId=" + subscriptionId + ", circleId=" + circleId + ", emailId=" + emailId
				+ ", status=" + status + ", subcriptionDate=" + subcriptionDate + "]";
	}

}
