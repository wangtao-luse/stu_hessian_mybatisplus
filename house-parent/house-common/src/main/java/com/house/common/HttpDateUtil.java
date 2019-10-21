package com.house.common;

import javax.servlet.http.HttpServletRequest;

import com.alibaba.fastjson.JSONObject;
import com.house.req.RequestBody;
import com.house.req.RequestHead;
import com.house.req.RequestMessage;

public class HttpDateUtil {

public static RequestMessage postData(String functionMethod,JSONObject content,HttpServletRequest request) {
	RequestMessage requestMessage = new RequestMessage();
	RequestHead header = new RequestHead();
	header.setFunctionMethod(functionMethod);
	requestMessage.setHead(header);
	
	RequestBody body = new RequestBody();
	body.setContent(content);
	requestMessage.setBody(body);
	return requestMessage;
}
}
