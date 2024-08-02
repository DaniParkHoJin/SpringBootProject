package com.hojin.common.aop;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@Aspect
public class ServiceLoggerAdvice {
	// com.zeus.service.BoardService 클래스에 속한 임의의 메서드를 대상으로 한다. 
	@After("execution(* com.zeus.service.BoardService*.*(..))")
	public void endLog(JoinPoint jp) {
	log.info("endLog");
	log.info("endLog : " + jp.getSignature());
	log.info("endLog : " + Arrays.toString(jp.getArgs()));
	}

}
