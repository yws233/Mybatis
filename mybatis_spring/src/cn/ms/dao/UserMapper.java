package cn.ms.dao;

import java.util.List;
import java.util.Map;

import cn.ms.pojo.User;
import org.apache.ibatis.annotations.Param;


public interface UserMapper {

	/**
	 * 查询用户列表(参数：对象入参)
	 * @return
	 */
	public List<User> getUserList(User user);

	
	/**
	 * 增加用户
	 * @param user
	 * @return
	 */
	public int add(User user);

}
