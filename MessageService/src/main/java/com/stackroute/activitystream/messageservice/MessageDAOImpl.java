package com.stackroute.activitystream.messageservice;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository("messageDAO")
@Transactional
public class MessageDAOImpl implements MessageDAO {
	@Autowired
	private SessionFactory sessionFactory;

	public MessageDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public boolean sendMessageToCircle(Message message) {
		try {
			message.setSendDate(new Date()); // date is set
			sessionFactory.getCurrentSession().save(message);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean sendMessageToUser(Message message) {
		try {
			message.setSendDate(new Date());
			//message.setRecievingUserId(emailId);
			sessionFactory.getCurrentSession().save(message);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public List<Message> getMessagesByUser(String emailId) {
		try {
			List<Message> userMessages;
			Query query = sessionFactory.getCurrentSession().createQuery("from Message where recievingUserId = ?");
			query.setParameter(0, emailId);
			userMessages = query.list();
			return userMessages;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}

	@Override
	public List<Message> getMessagesByCircle(int circleId) {
		try {
			List<Message> circleMessages;
			Query query = sessionFactory.getCurrentSession().createQuery("from Message where receivingCircleId = ?");
			query.setParameter(0, circleId);
			query.setMaxResults(10);
			circleMessages = query.list();
			return circleMessages;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
