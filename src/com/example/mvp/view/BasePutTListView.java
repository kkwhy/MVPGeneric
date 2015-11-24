package com.example.mvp.view;

import java.util.List;

public interface BasePutTListView<V> {
	void putVList(String json,List<V> vList,int status,String msg);
}
