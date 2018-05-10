package com.huyanqiu.springbootall.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.autoconfigure.web.HttpMessageConverters;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;

/**
 * 基本的web配置文件（跨域、欢迎页面、静态资源文件......）
 * @author huyanqiu
 * @date 2018年5月10日下午1:25:05
 * @version 版本号：1.0
 */
@Configuration
public class WebConfig extends WebMvcConfigurerAdapter{
	
	/**
	 * 添加静态资源映射
	 */
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/**").addResourceLocations("classpath:/tender/");
		super.addResourceHandlers(registry);
	}
	 /**
     * 替换json框架为fastjson
     * @return
     */
    @Bean
    public HttpMessageConverters fastJsonHttpMessageConverters() {
       FastJsonHttpMessageConverter fastConverter = new FastJsonHttpMessageConverter();
       FastJsonConfig fastJsonConfig = new FastJsonConfig();
       fastJsonConfig.setSerializerFeatures(SerializerFeature.PrettyFormat, SerializerFeature.WriteMapNullValue,SerializerFeature.WriteNullNumberAsZero,SerializerFeature.WriteNullStringAsEmpty);
       fastConverter.setFastJsonConfig(fastJsonConfig);
       
       HttpMessageConverter<?> converter = fastConverter;
       //处理中文乱码问题
       List<MediaType> fastMediaTypes = new ArrayList<>();
       fastMediaTypes.add(MediaType.APPLICATION_JSON_UTF8);
       fastConverter.setSupportedMediaTypes(fastMediaTypes);
       
       return new HttpMessageConverters(converter);
    }
	/** 
     *  
     * attention:简单跨域就是GET，HEAD和POST请求，但是POST请求的"Content-Type"只能是application/x-www-form-urlencoded, multipart/form-data 或 text/plain 
     * 反之，就是非简单跨域，此跨域有一个预检机制，说直白点，就是会发两次请求，一次OPTIONS请求，一次真正的请求 
     */
    @Bean  
    public CorsFilter corsFilter() {  
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();  
        source.registerCorsConfiguration("/**", buildConfig());  
        return new CorsFilter(source);  
    }
	private CorsConfiguration buildConfig() {
		CorsConfiguration config = new CorsConfiguration();  
        config.setAllowCredentials(true); // 允许cookies跨域  
        config.addAllowedOrigin("*");// #允许向该服务器提交请求的URI，*表示全部允许，在SpringMVC中，如果设成*，会自动转成当前请求头中的Origin  
        config.addAllowedHeader("*");// #允许访问的头信息,*表示全部  
        config.setMaxAge(18000L);// 预检请求的缓存时间（秒），即在这个时间段里，对于相同的跨域请求不会再预检了  
        config.addAllowedMethod("*");
		return config;
	}
}
