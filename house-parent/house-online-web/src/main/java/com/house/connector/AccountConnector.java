package com.house.connector;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.alibaba.fastjson.JSONObject;
import com.house.api.AccountServiceApi;
import com.house.common.HttpDateUtil;
import com.house.common.URLMapping;
import com.house.req.RequestMessage;
import com.house.resp.ResponseMessage;

@Controller
public class AccountConnector {
	@Autowired 
 AccountServiceApi accountServiceApi;
public ResponseMessage sayHello(JSONObject jsonObject,HttpServletRequest request) {
	RequestMessage requestMessage = HttpDateUtil.postData(URLMapping.ACCOUNT_SAYHELLO,jsonObject, request);	 
	return accountServiceApi.callService(requestMessage);
}
}
