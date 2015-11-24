package com.example.mvp.bean.response;

public class BaseResponseBean<V> {
	private V data;
	
	private int status;
	
	private String msg;

	public V getData() {
		return data;
	}

	public void setData(V data) {
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
