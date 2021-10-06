package com.elec.demo.aop;

import com.elec.demo.result.ResultOne;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@Component
@ControllerAdvice
public class ControllerExceptionHandlerAdvice {
	@ExceptionHandler
	@ResponseBody
	public ResultOne<String> exceptionHandler(Exception ex) throws Exception{
		ResultOne<String> result=new ResultOne<String>();
		result.setStatus("ERROR");
		result.setResult("请求出现异常");
		result.setMessage("异常原因:"+ex.getLocalizedMessage());
		return result;
	}
}
