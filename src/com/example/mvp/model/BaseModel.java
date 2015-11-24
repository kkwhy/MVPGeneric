package com.example.mvp.model;

import java.util.List;

import com.squareup.okhttp.Callback;

public interface BaseModel<T> {
	void get(String url,Callback cb);
	
	void post(String url,T t,Callback cb);
	
	void postList(String url,List<T> tList,Callback cb);
	
	void delete(String url,T t,Callback cb);
	
	void deleteList(String url,List<T> tList,Callback cb);
	
	void put(String url,T t,Callback cb);
	
	void putList(String url,List<T> tList,Callback cb);
}
