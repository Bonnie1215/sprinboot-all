package com.huyanqiu.springbootall.appender;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartException;

import com.huyanqiu.springbootall.domain.vo.SysResult;

/**
 * 全局异常catch处理类--  处理500
 * @author huyanqiu
 * @date 2018年5月10日下午2:23:14
 * @version 版本号：1.0
 */
@ControllerAdvice
public class GlobalExceptionHandler {
	@Value("${sys.debug}")
	private boolean debug;
	
	@ExceptionHandler(Exception.class)
	@ResponseBody
	public SysResult handlerException(Exception ex){
		ex.printStackTrace();
		if(debug){
			return SysResult.error(ex.getMessage());
		}
		return SysResult.error();
	}
	
	@ExceptionHandler(MultipartException.class)
	@ResponseBody
	public SysResult handleMultipartException(MultipartException ex) {
		if(debug) {
			ex.printStackTrace();
		}
		return SysResult.error("超过最大上传文件限制");
	}
}
