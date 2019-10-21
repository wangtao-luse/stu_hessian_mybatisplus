package com.house.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
    @RequestMapping("/index")
	public String index() {
		return "/index";
	}
    @RequestMapping("/zufang")
    public String zufang() {
    	return "zf/zufang";
    }
    @RequestMapping("/houseDetail")
    public String houseDetail(){
    	return "zf/house-detail";
    }
}
