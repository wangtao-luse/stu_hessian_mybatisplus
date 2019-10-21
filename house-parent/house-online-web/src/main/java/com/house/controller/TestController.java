package com.house.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.house.api.AccountServiceApi;
import com.house.common.HttpDateUtil;
import com.house.connector.AccountConnector;
import com.house.req.RequestMessage;
import com.house.resp.ResponseMessage;


@Controller
public class TestController {
	@Autowired
	AccountConnector accountConnector;
	  
	 
	@RequestMapping("/sayHello")
	@ResponseBody
	public ResponseMessage sayHello(@RequestBody(required = false) JSONObject jsonObject,HttpServletRequest request) {
		if(StringUtils.isEmpty(jsonObject)) {
			jsonObject = new JSONObject();
			jsonObject.put("id", "8625");
		}
		ResponseMessage sayHello = this.accountConnector.sayHello(jsonObject, request);
		 return sayHello;
		
	}
}
