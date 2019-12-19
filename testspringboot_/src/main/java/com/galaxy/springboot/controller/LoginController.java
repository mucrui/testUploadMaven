package com.galaxy.springboot.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * PageController就是为了跳转
 * @author Lenovo
 *
 */
@Controller
@RequestMapping("/sysUser")
public class LoginController {

	
	
	@RequestMapping("/login")
	public String login(HttpServletRequest request) {
		System.out.println("逻辑视图");
		
		return "redirect:../index.html";
	}
	
}
