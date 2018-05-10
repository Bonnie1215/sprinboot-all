package com.huyanqiu.springbootall.appender;

import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.huyanqiu.springbootall.domain.vo.SysResult;

/**
 * 全局访问失败处理类 -- 处理404
 * @author huyanqiu
 * @date 2018年5月10日下午2:25:29
 * @version 版本号：1.0
 */
@Controller
public class MainsiteErrorController implements ErrorController {
	
	//定义404的@RequestMapping
	public static final String ERROR_PATH = "/error"; 
	
	@RequestMapping(value = ERROR_PATH, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public SysResult handleError(){
		return SysResult.error("404-error");
	}
	
	@Override
	public String getErrorPath() {
		return ERROR_PATH;
	}

}