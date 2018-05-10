package com.huyanqiu.springbootall.appender;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 欢迎页面
 * 虽然有index.html但是也一定要添加thymeleaf依赖才会生效
 * @author huyanqiu
 * @date 2018年5月10日下午2:27:58
 * @version 版本号：1.0
 */
@Controller
public class DefaultViewController {
	
	@RequestMapping("/")
	public String index(){
		return "index";
	}
	
}
