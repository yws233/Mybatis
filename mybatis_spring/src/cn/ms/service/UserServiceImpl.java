package cn.ms.service;

import java.util.List;

import cn.ms.dao.UserMapper;
import cn.ms.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Transactional(propagation = Propagation.REQUIRED)
@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired
	@Qualifier("userMapper")
	private UserMapper userMapper;
	public UserMapper getUserMapper() {
		return userMapper;
	}
	public void setUserMapper(UserMapper userMapper) {
		this.userMapper = userMapper;
	}
	@Override
	public List<User> findUsers(User user) {
		// TODO Auto-generated method stub
		return userMapper.getUserList(user);
	}

	@Override
	public boolean addNewUser(User user) {
		boolean result = false;
		if (userMapper.add(user) == 1){
			result = true;
		}
		return result;
	}

	@Override
	public void addNewUser(List<User> users) {
		for (User user : users){
			addNewUser(user); //模拟添加多个用户，测试事务控制
            //throw new RuntimeException("增加用户失败"); //模拟添加第一个用户后抛出异常
		}
	}

}
