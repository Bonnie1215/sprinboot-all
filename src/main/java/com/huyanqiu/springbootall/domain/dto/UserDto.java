package com.huyanqiu.springbootall.domain.dto;

public class UserDto {
	
	private int pageNum = 1;
	private int pageSize = 10;
	public int getPageNum() {
		return pageNum;
	}
	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	
}
