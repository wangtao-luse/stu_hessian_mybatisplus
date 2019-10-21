package com.house.core.hessian;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.house.api.AccountServiceApi;
import com.house.common.URLMapping;
import com.house.core.impl.TestService;
import com.house.req.RequestMessage;
import com.house.resp.ResponseMessage;

@Service
public class accountServiceImpl implements AccountServiceApi{
	@Autowired
	TestService testService;
	@Override
	public ResponseMessage callService(RequestMessage requestMessage) {
		// TODO Auto-generated method stub
		String functionMethod = requestMessage.getHead().getFunctionMethod();		
		if(URLMapping.ACCOUNT_SAYHELLO.equals(functionMethod)) {
		 return testService.sayHello(requestMessage);
		}
		return null;
		
	}

}
