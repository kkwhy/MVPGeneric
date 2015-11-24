package com.example.mvp.view;

import java.util.List;

public interface BasePostTView<V> {
	void postV(String json,V v,int status,String msg);
}
