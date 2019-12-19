package com.galaxy.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.galaxy.springboot.entity.TbUser;
import com.galaxy.springboot.service.UserService;

@RestController//测试数据不跳转
public class UserController {

	@Autowired
	private UserService userService;
	
	@RequestMapping("/hello")
	public String hello() {
		return "hello world访问成功";
	}
	
	@RequestMapping("/list")
	public List<TbUser> list() {
		return userService.selectLists();
	}
	
	
}
