package com.test.aop.cotroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.test.aop.service.MemoService;

@Controller
public class MemoController {

	@Autowired
	private MemoService service;

	
	@GetMapping("/list.do")
	public String list() {
		
		List<Object> list = service.list();
		
		return "list";
	}
	
	@GetMapping("/add.do")
	public String add() {
		
		int result = service.add("메모입니다.");
		
		return "add";
	}
	
	@GetMapping("/view.do")
	public String view() {
		
		Object memo = service.view(5);
		
		return "view";
	}
	
	
}

