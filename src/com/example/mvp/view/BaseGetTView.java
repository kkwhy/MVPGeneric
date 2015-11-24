package com.example.mvp.view;

public interface BaseGetTView<V> {
	void getV(String json,V v,int status,String msg);
}
