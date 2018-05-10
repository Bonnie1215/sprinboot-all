package com.huyanqiu.springbootall.domain.vo;

import java.util.Map;

import com.github.pagehelper.PageInfo;

import java.util.HashMap;

/**
 * 返回封装分页的结果集
 * @author meisanfeng
 *
 */
public class SysResultByPage {
	
	public static void main(String[] args) {
		PageInfo<String> pageInfo = new PageInfo<>();
		SysResult ok = SysResultByPage.ok(pageInfo.getList(), pageInfo.getTotal());
		System.out.println(ok);
	}
	
	public static SysResult ok(Object data, Object total){
		return SysResult.ok(buildData(data, total));
	}
	
	public static SysResult ok(String msg, Object data, Object total){
		return SysResult.ok(msg, buildData(data, total));
	}
	
	public static SysResult ok(Integer code, String msg, Object data, Object total){
		return SysResult.ok(code, msg, buildData(data, total));
	}
	
	private static Object buildData(Object data, Object total){
		Map<String, Object> pageInfo = new HashMap<>();
		pageInfo.put("total", total);
		
		Map<String, Object> map = new HashMap<>();
		map.put("list", data);
		map.put("pageInfo", pageInfo);
		return map;
	}

	/*
	* 护工提成表定制
	* */
	public static SysResult ok(Object durationCount,Object bonusCount,Object list, Object total){
		return SysResult.ok(buildData2(durationCount,bonusCount,list,total));
	}

	private static Object buildData2(Object durationCount,Object bonusCount,Object list, Object total){
		Map<String, Object> pageInfo = new HashMap<>();
		pageInfo.put("total", total);

		Map<String, Object> map = new HashMap<>();
		map.put("list", list);
		map.put("durationCount", durationCount);
		map.put("bonusCount", bonusCount);
		map.put("pageInfo", pageInfo);
		return map;
	}
	
}
