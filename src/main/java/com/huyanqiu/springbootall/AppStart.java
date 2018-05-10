package com.huyanqiu.springbootall;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
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
