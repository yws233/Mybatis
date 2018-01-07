package test;

import static org.junit.Assert.*;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.ms.dao.UserMapper;
import cn.ms.pojo.User;
import cn.ms.service.UserService;
import cn.ms.utils.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class UserMapperTest {
	
	private Logger logger = Logger.getLogger(UserMapperTest.class);
	
	@Before
	public void setUp() throws Exception {
	}

	/*
	*
	*  使用注解的方式获取
	* */
	@Test 
	public void testUserService(){
		User userCondition = new User();
		userCondition.setUserName("赵");
		userCondition.setUserRole(3);		
	
		ApplicationContext ctx=new 
				ClassPathXmlApplicationContext("applicationContext.xml");
		
		UserService userService= (UserService) ctx.getBean("userService");
		
		
		List<User> userList = userService.findUsers(userCondition);
	
		for(User user: userList){
			logger.debug("testGetUserList userCode: " + user.getUserCode() + 
						" and userName: " + user.getUserName() + 
						" and userRole: " + user.getUserRole() + 
						" and userRoleName: " + user.getUserRoleName() +
						" and age: " + user.getAge() +
						" and address: " + user.getAddress());
		}
	}
	@Test
	public void testGetUserList(){
		
		User userCondition = new User();
		userCondition.setUserName("赵");
		userCondition.setUserRole(3);		
		//UserMapper userMapper=new UserMapperImpl();
		//使用Spring注入的方式获取
		ApplicationContext ctx=new 
				ClassPathXmlApplicationContext("applicationContext.xml");
		//查看获取哪些bean
        for (String name:ctx.getBeanDefinitionNames()
             ) {
            logger.info("bean id:>>>>>>>" + name);
            
        }
        UserMapper userMapper=(UserMapper) ctx.getBean("userMapper");
		List<User> userList = userMapper.getUserList(userCondition);
		for(User user: userList){
			logger.debug("testGetUserList userCode: " + user.getUserCode() + 
						" and userName: " + user.getUserName() + 
						" and userRole: " + user.getUserRole() + 
						" and userRoleName: " + user.getUserRoleName() +
						" and age: " + user.getAge() +
						" and address: " + user.getAddress());
		}
	}

	
	@Test
	public void testAddNewUser(){
		User user = new User();
		user.setUserName("注解测试");
		user.setUserRole(3);
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		UserService userService = (UserService) context.getBean("userService");

		List<User> userList = new ArrayList<>();
		userList.add(user);
		userList.add(user);
		userService.addNewUser(userList);
	}


}
