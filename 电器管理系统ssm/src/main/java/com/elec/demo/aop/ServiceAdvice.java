package com.elec.demo.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


@Component
@Aspect
public class ServiceAdvice {

//	@Before(value="execution(* com.city.erp.service.impl.*.*(..))")
	@Before(value="com.elec.demo.aop.AopPointcut.ServiceallMethodPointcut()")
	public void runBefore() throws Exception{
		System.out.println("实现前切");

	}
	//@After(value="execution(* com.city.erp.service.impl.*.*(..))")
	@AfterReturning(value="com.elec.demo.aop.AopPointcut.ServiceallMethodPointcut()")
	public void runAfterReturning() throws Exception{
		System.out.println("实现后切");

	}

	@Around(value="com.elec.demo.aop.AopPointcut.ServiceallMethodPointcut()")
	public Object serviceMethodRunTime(ProceedingJoinPoint pjp) throws Throwable {
	// start stopwatch
	Date start = new Date();	
	Object retVal = pjp.proceed();	
	Date end = new Date();
	System.out.println("类："+pjp.getTarget().getClass().getName()+"，方法："+pjp.getSignature().getName()+"，执行时间是："+(end.getTime()-start.getTime())+"毫秒");
	return retVal;
	}

	@AfterThrowing(value="com.elec.demo.aop.AopPointcut.ServiceallMethodPointcut()",throwing="ex")
	public void exceptionHanding(JoinPoint jp, Exception ex) {
	// 切面代码
		Date time = new Date();
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		System.out.println("类："+jp.getTarget().getClass().getName()+"，方法："+jp.getSignature().getName()+"，执行时间是："+df.format(time)+"毫秒,异常"+ex.getMessage());
		
	}


	
}
