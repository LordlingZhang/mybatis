package sy.test;

import java.util.Date;
import java.util.List;

import org.apache.commons.logging.impl.Log4JLogger;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.JSONLibDataFormatSerializer;

import sy.model.User;
import sy.service.UserServiceI;

@RunWith(SpringJUnit4ClassRunner.class)//作用相当于继承了SpringJUnit4ClassRunner
@ContextConfiguration(locations = {"classpath:spring.xml","classpath:spring-mybatis.xml"})
public class UserTest {
	
//	private ApplicationContext ac;
	private static Logger logger = Logger.getLogger(UserTest.class);
	
	private UserServiceI u;
	
	public UserServiceI getU() {
		return u;
	}
	@Autowired
	public void setU(UserServiceI u) {
		this.u = u;
	}
	
	
	/*@Before //利用注解，就不需要junit的注解了
	public void before(){
		ac = new ClassPathXmlApplicationContext(new String[]{"spring.xml","spring-mybatis.xml"});
		u = (UserServiceI) ac.getBean("userService");
	}*/
	
	@Test
	public void selectUser(){
		User user = u.getUser("1");
		logger.info(JSON.toJSONStringWithDateFormat(user, "yyyy-MM-dd HH:mm:ss"));
	}
	@Test
	public void selectAllUser(){
		List<User> userList = u.getAll();
		logger.info(JSON.toJSONStringWithDateFormat(userList, "yyyy-MM-dd HH:mm:ss"));
	}
	
//	@Test
//	public void testInsertUser(){
//		User user = new User();
//		user.setId("3");
//		user.setName("sb");
//		user.setPwd("123");
//		user.setCreateTime(new Date());
//		u.insertUser(user);
//	}
}
