package com.huyanqiu.springbootall;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication //申明让spring boot自动给程序进行必要的配置
@ServletComponentScan   //开启后支持自定义Servlet和Filter
@EnableScheduling       //支持定时任务
@MapperScan(basePackages={"com.huyanqiu.springbootall.mapper"}) // 扫描mapper的java文件，否则每个Mapper文件上都需要加 @Mapper注解
/**
 * DataSourceAutoConfiguration类使用了@Configuration注解向spring注入了dataSource bean。
 * 因为工程中没有关于dataSource相关的配置信息，
 * 当spring创建dataSource bean因缺少相关的信息就会报错。
 */
//@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class}) 
public class AppStart {

	public static void main(String[] args) {
		SpringApplication.run(AppStart.class, args);
	}
}
