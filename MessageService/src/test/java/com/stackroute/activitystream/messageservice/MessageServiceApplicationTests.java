package com.stackroute.activitystream.messageservice;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class MessageServiceApplicationTests {

	private Message message;
	
	@Autowired
	MessageDAO messageDAO;
	
	@Before
	public void init()
	{
		message = new Message();
	}
	
	@Test
	public void sendMessageToUserTest() {
		message.setContent("this is my First Message");
		message.setMessageType("Test");
		message.setSenderId("zaid3891@gmail.com");
		message.setRecievingUserId("ansari.zaid@niit.com");
		assertEquals("message send",true, messageDAO.sendMessageToUser(message));
		
	}
	
	@Test
	public void sendMessageToCircleTest() {
		message.setContent("this is my First Message");
		message.setMessageType("Test");
		message.setSenderId("zaid3891@gmail.com");
		message.setReceivingCircleId(3);
		assertEquals("message send",true, messageDAO.sendMessageToCircle(message));
		
	}

	@Test
	public void getMessagesByUserTest()
	{
		List<Message> allUserMessages;
		allUserMessages = messageDAO.getMessagesByUser("ansari.zaid@niit.com");
		assertNotNull(allUserMessages);
		System.out.println(allUserMessages);
	}
	
	@Test
	public void getMessagesByCircleTest()
	{
		List<Message> allCircleMessages;
		allCircleMessages = messageDAO.getMessagesByCircle(5);
		assertNotNull(allCircleMessages);
		System.out.println(allCircleMessages);
	}
}
