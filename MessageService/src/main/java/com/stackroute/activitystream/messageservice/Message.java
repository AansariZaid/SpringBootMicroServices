package com.stackroute.activitystream.messageservice;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

@Entity
@Component
public class Message {

	@Id
	private int messageId;
	@Column
	private String content;
	@Column
	private String senderId;
	@Column
	private String messageType;
	@Column
	private String recievingUserId;
	@Column
	private int receivingCircleId;
	@Column
	private Date sendDate;

	public int getMessageId() {
		return messageId;
	}

	public void setMessageId(int messageId) {
		this.messageId = messageId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getSenderId() {
		return senderId;
	}

	public void setSenderId(String senderId) {
		this.senderId = senderId;
	}

	public String getMessageType() {
		return messageType;
	}

	public void setMessageType(String messageType) {
		this.messageType = messageType;
	}

	public Date getSendDate() {
		return sendDate;
	}

	public void setSendDate(Date sendDate) {
		this.sendDate = sendDate;
	}

	public String getRecievingUserId() {
		return recievingUserId;
	}

	public void setRecievingUserId(String recievingUserId) {
		this.recievingUserId = recievingUserId;
	}

	public int getReceivingCircleId() {
		return receivingCircleId;
	}

	public void setReceivingCircleId(int receivingCircleId) {
		this.receivingCircleId = receivingCircleId;
	}

	@Override
	public String toString() {
		return "Message [messageId=" + messageId + ", content=" + content + ", senderId=" + senderId + ", messageType="
				+ messageType + ", recievingUserId=" + recievingUserId + ", receivingCircleId=" + receivingCircleId
				+ ", sendDate=" + sendDate + "]";
	}


}
