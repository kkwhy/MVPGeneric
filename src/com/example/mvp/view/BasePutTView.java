package com.example.mvp.view;

import java.util.List;

public interface BasePutTView<V> {
	void putV(String json,V v,int status,String msg);
}
