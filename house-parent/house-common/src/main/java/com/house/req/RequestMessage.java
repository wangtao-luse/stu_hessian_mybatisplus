package com.house.req;

import java.io.Serializable;

import lombok.Data;

@Data
public class RequestMessage implements Serializable {
private RequestHead head;
private RequestBody body;

}
