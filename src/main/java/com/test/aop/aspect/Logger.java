package com.test.aop.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

//보조 업무 객체
//1. 스프링 빈
//2. 보조업무 객체 역할 부여

@Component
@Aspect
public class Logger {
	
	//포인트컷 + 보조업무 = 결합
//	@After("execution(* *..MemoService.add(..))")
//	public void m1() {
//		System.out.println("[로그] 기록합니다.");
//	}
	
	//포인트컷
	@Pointcut("execution(* *..MemoService.add(..))")
	public void pc1() {
		
	}

	@Pointcut("execution(* *..MemoService.list(..))")
	public void pc2() {
		
	}
	
	//보조업무 + 위빙(advice)
	@After("pc1() || pc2()")
	public void m1() {
		System.out.println("[로그] 기록합니다.");
		
	}

	@Before("pc1()")
	public void m2() {
		System.out.println("[인증] 접근 권한 확인");
		
	}

	@Before("pc1()")
	public void m3() {
		System.out.println("[인증] 소셜 권한 확인");
		
	}
	
	
	

}
