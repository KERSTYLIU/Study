package com.elec.demo.aop;


import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AopPointcut {
	//业务层所有方法切入点
	@Pointcut(value="execution(* com.elec.demo.service.impl.*.*(..))")
	public void ServiceallMethodPointcut() {}
	//业务层所有查询方法切入点
	@Pointcut(value="execution(* com.elec.demo.service.impl.*.select*(..))")
	public void ServiceRetriveMethodPointcut() {}
}
