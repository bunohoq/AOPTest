# Spring AOP 예제

Spring Framework의 AOP(Aspect-Oriented Programming)를 사용하여 핵심 비즈니스 로직과 공통 기능(Cross-Cutting Concerns)을 분리하는 예제 프로젝트.

## ✨ 주요 기능

* **`@Aspect`**, **`@Component`**: `Logger.java` 클래스를 공통 기능(Aspect)을 담는 스프링 빈으로 등록했음.
* **`@Pointcut`**: `MemoService`의 특정 메소드(`add`, `list`)를 주 업무(JoinPoint)로 지정하는 Pointcut을 정의했음.
* **`@Before`**, **`@After`**: Pointcut으로 지정된 메소드가 실행되기 전(`@Before`)과 후(`@After`)에 로그 기록, 인증 확인 등의 보조 업무(Advice)를 삽입(Weaving)했음.

## 🛠️ 사용 기술

* **Backend**: Spring MVC, Spring AOP (AspectJ)
* **Frontend**: JSP
* **Server**: Apache Tomcat

## ⚙️ 실행 흐름

1.  사용자가 `/aop/add.do` 또는 `/aop/list.do` 요청.
2.  `MemoController`가 요청을 받아 `MemoService`의 메소드(`add()`, `list()`)를 호출.
3.  Spring AOP 프록시가 메소드 호출을 가로챔(Intercept).
4.  `@Pointcut` 조건과 일치하므로 `Logger` Aspect의 보조 업무(Advice) 실행.
    * `@Before`: `[인증]` 로그를 먼저 출력.
    * **Target 실행**: 원래 `MemoService`의 `add()` 또는 `list()` 메소드 실행.
    * `@After`: `[로그]` 기록을 마지막으로 출력.
5.  모든 처리가 완료된 후 `Controller`로 제어권이 돌아와 사용자에게 View를 반환.

## 🚀 실행

1.  프로젝트를 IDE(Eclipse, STS 등)로 임포트.
2.  Maven 의존성 설치.
3.  Apache Tomcat 서버에 프로젝트 배포 후 실행.
4.  웹 브라우저에서 `/aop/list.do`, `/aop/add.do` 등으로 접근하여 콘솔 로그 확인.
