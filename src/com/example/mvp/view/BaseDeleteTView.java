package com.example.mvp.view;

import java.util.List;

public interface BaseDeleteTView<V> {
	void deleteV(String json,V v,int status,String msg);
}
