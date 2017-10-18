package com.stackroute.activitystream.userservice;

import java.util.List;

public interface UserDAO {
	public Boolean register(User user);
	public User validate(User user);
	public Boolean Update(User user);
	public Boolean delete(String emailid);
	public List<User> getAllUser();
	public User getUser(String emailid);
}
