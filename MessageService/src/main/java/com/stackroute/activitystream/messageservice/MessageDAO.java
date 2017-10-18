package com.stackroute.activitystream.messageservice;

import java.util.List;

public interface MessageDAO {

	boolean sendMessageToCircle(Message message);

	boolean sendMessageToUser(Message message);

	List<Message> getMessagesByUser(String emailId);

	List<Message> getMessagesByCircle(int circleId);

}
