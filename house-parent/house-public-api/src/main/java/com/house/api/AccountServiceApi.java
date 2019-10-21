package com.house.api;

import com.house.req.RequestMessage;
import com.house.resp.ResponseMessage;

public interface AccountServiceApi {
ResponseMessage callService(RequestMessage requestMessage);


}
