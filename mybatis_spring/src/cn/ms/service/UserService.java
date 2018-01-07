package cn.ms.service;


import cn.ms.pojo.User;

import java.util.List;


public interface UserService {

	public List<User>  findUsers(User user);

	boolean addNewUser(User user);

	void addNewUser(List<User> users);


}
