package com.example.demo;

import com.example.demo.amqp.AmqpComponet;
import com.example.demo.bean.MkUser;
import com.example.demo.bean.RoncooUserLog;
import com.example.demo.componet.RoncooRedisComponent;
import com.example.demo.dao.RoncooUserLogDao;
import com.example.demo.jms.JmsComponet;
import com.example.demo.mapper.MkUserMapper;
import com.example.demo.service.UserService;
import com.example.demo.web.HomeController;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Date;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootApplicationTests {

	@Autowired
	private RoncooUserLogDao roncooUserLogDao;

	@Autowired
	private UserService userService;

	@Autowired
	private RoncooRedisComponent redisComponent;

	@Autowired
	private JmsComponet jmsComponet;

//	@Autowired
//	private AmqpComponet amqpComponet;

	@Autowired
	private MkUserMapper mkUserMapper;

	//mock测试
	private MockMvc mvc;

	@Before
	public void before(){
		this.mvc= MockMvcBuilders.standaloneSetup(new HomeController()).build();
	}

	@Test
	public void contextLoads() throws Exception {
		RequestBuilder req=get("/login");
		mvc.perform(req).andExpect(status().isOk()).andExpect(content().string("login"));
	}

	@Test
	public void insert() {
		RoncooUserLog entity = new RoncooUserLog();
		entity.setUserName("无境");
		entity.setUserIp("192.168.0.1");
		entity.setCreateTime(new Date());
		roncooUserLogDao.save(entity);
	}

	@Test
	public void update() {
		RoncooUserLog entity = new RoncooUserLog();
		entity.setId(2);
		entity.setUserName("无境2");
		entity.setUserIp("192.168.0.1");
		entity.setCreateTime(new Date());
		roncooUserLogDao.save(entity);
	}

	@Test
	public void delete() {
		roncooUserLogDao.delete(2);
	}

	@Test
	public void select() {
		RoncooUserLog result = roncooUserLogDao.findOne(1);
		System.out.println(result);
	}

	@Test
	public void select2(){
		RoncooUserLog userLog=roncooUserLogDao.findByUserName("无境");
		System.out.println(userLog);
	}

	@Test
	public void testRegister(){
		userService.register("张三2","192.168.1.2");
	}

	//测试redis
	@Test
	public void testRedis(){
//		redisComponent.set("roncoo","hello world");
//		System.out.println(redisComponent.get("roncoo"));
		redisComponent.del("roncoo");
	}

	//测试jms
	@Test
	public void testJms(){
		jmsComponet.send("jms monkey");
	}

	//测试amqp
	@Test
	public void testAmqp(){
//		amqpComponet.send("amqp monkey 2");
	}

	@Test
	public void testMybatisInsert(){
		MkUser user=new MkUser();
		user.setName("历史");
		user.setCreateTime(new Date());
		int rownum= mkUserMapper.insert(user);//得到的是受影响行数
		System.out.println(user);
		System.out.println("insert rownum = "+rownum);
	}

	@Test
	public void testMybatisSelect(){
		MkUser user=mkUserMapper.selectByPrimaryKey(2);
		System.out.println(user);
	}

}
