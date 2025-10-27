package com.test.aop.service;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class MemoService {

	public List<Object> list() {
		System.out.println("메모 목록보기");
		return null;
	}

	public int add(String string) {
		System.out.println("메모 쓰기");
		return 0;
	}

	public Object view(int i) {
		System.out.println("메모 상세보기");
		return null;
	}

	
	
}
