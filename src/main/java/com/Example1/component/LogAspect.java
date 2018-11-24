/*package com.Example1.component;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.junit.After;
import org.junit.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LogAspect {
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Before("execution(* com.Example1.service.*)")
	public void onBeforeHandler(JoinPoint joinPoint) {
		logger.info("=============== onBeforeThing");
	}

	@After("execution(* com.Example1.service.*.*Aop(..))")
	public void onAfterHandler(JoinPoint joinPoint) {
		logger.info("=============== onAfterHandler");
	}

	@AfterReturning(pointcut = "execution(* com.Example1.service.*.*Aop(..))", returning = "str")
	public void onAfterReturningHandler(JoinPoint joinPoint, Object str) {
		logger.info("@AfterReturning : " + str);
		logger.info("=============== onAfterReturningHandler");
	}

	@Pointcut("execution(* com.Example1.service.*.*Aop(..))")
	public void onPointcut(JoinPoint joinPoint) {
		logger.info("=============== onPointcut");
	}
}*/