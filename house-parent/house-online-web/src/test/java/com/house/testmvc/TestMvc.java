package com.house.testmvc;

import java.nio.charset.Charset;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.alibaba.fastjson.JSONObject;
/**
 * https://blog.csdn.net/zezezuiaiya/article/details/81938441
 * @WebAppConfiguration:用于声明一个ApplicationContext集成测试加载WebApplicationContext。作用是模拟ServletContext
 * perform():执行一个RequestBuilder请求，会自动执行SpringMVC的流程并映射到相应的控制器执行处理
 */
@RunWith(SpringJUnit4ClassRunner.class)//需要servlet-api 3.0+的支持
@WebAppConfiguration
@ContextConfiguration(locations = {"classpath:springmvc/springMVC-servlet.xml","classpath:spring/spring-hessian-client.xml"})
public class TestMvc {
	@Autowired
	WebApplicationContext context;//注入springmvc的ioc
	MockMvc mockMvc;//虚拟mvc发送请求 返回处理结果
	@Before
	public void initMockMvc() {
		 mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
	}
	@Test//发送JSON 数据 需要先启动Service;
	public void testSayHello() throws Exception {
		//1.准备向后台发送JSON格式的数据
		JSONObject jsonObject = new JSONObject();
		 jsonObject.put("hello", "你好世界！");
		 jsonObject.put("id", "8623");
		 //2.调用接口
		MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/sayHello")
				.contentType(MediaType.APPLICATION_JSON)
				.content(jsonObject.toJSONString())
				;
		MvcResult andReturn = mockMvc.perform(requestBuilder)				
				.andReturn();
		//3.1获取请求数据
		MockHttpServletRequest request = andReturn.getRequest();
		request.setCharacterEncoding("UTF-8");
		String request_data = request.getContentAsString();		
		System.out.println("request:*****"+request_data);	
		//3.1.方法返回的JSON字符串
		MockHttpServletResponse response = andReturn.getResponse();
		String response_data = response.getContentAsString(Charset.forName("UTF-8"));
		System.out.println("response:*****"+response_data);
	}
	
}
