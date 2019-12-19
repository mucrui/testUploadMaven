package com.galaxy.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * PageController就是为了跳转
 * @author Lenovo
 *
 */
@Controller //不能加@RestController，返回json串
public class PageController {

	@RequestMapping("/hao")
	public String index() {
		System.out.println("逻辑视图");
		return "index";
	}
}
