package org.spring.myapp.advice;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

//aop구현
@Component //스프링이 자동 객체 생성
@Aspect
public class AopAdvice {
	@Before("execution(* org.spring.myapp.controller.*.*(..))")
	public void beforeLog(JoinPoint jp) {
		System.out.println(jp.getSignature().toShortString() + ":" +Arrays.toString(jp.getArgs()));
		
	}
	
	//리턴값 출력
	//정상수행후 리턴되는 값을 찍어보자 
	@AfterReturning(pointcut = "execution(* org.spring.myapp.service.*.*(..))", returning = "rObj")
	public void afterLog(JoinPoint jp, Object rObj) {
		System.out.println(jp.getSignature().toShortString());
		if(rObj!=null)
		
			System.out.println("리턴값"+ rObj.toString());
		else
			System.out.println("리턴값없음");
	}
//	@Around("execution(* org.company.my.service.*.*(..))")
//	public Object around(ProceedingJoinPoint pjp) throws Throwable {
//		//시작시간
//		long startTime = System.currentTimeMillis();
//		
//		System.out.println(pjp.getSignature().toShortString()); //실행된 메소드명
//		Object result=pjp.proceed(); //실행돼야할메소드
//		//끝시간
//		long endTime = System.currentTimeMillis();
//		//소요시간
//		System.out.println("소요시간" +(endTime-startTime));
//		return result;
//		
//	}
}
