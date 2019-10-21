package com.house.core.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.alibaba.fastjson.JSONObject;
import com.house.model.Contract;
import com.house.persist.ContractMapper;
import com.house.req.RequestMessage;
import com.house.resp.ResponseMessage;
@Service
public class TestService {
	
	
	/*
	 * @Autowired ContractMapper contractMapper;
	 */
	 
	public ResponseMessage sayHello(RequestMessage requestMessage) {
		ResponseMessage resp = ResponseMessage.getSucess();
		/*try {*/
			 JSONObject jsonObject = requestMessage.getBody().getContent();
			 Long id = jsonObject.getLong("id");
			// Contract contract = contractMapper.queryById(id); 
			 resp.setReturnResult("contract");
		/*
		 * }catch (BaseException e) { // TODO: handle exception throw new
		 * BaseException(e.getMessage()); } catch (Exception e) { e.printStackTrace();
		 * throw new BaseException(ConstantBase.FAILED_SYSTEM_ERROR); }
		 */
		return resp;
	}

}
