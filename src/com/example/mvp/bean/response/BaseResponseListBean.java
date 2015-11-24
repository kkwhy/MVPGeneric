package com.example.mvp.bean.response;

import java.util.List;

public class BaseResponseListBean<T> {
	private List<T> data;
	
	private int status;
	
	private String msg;


	public List<T> getData() {
		return data;
	}

	public void setData(List<T> data) {
		this.data = data;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
}
