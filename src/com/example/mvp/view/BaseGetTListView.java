package com.example.mvp.view;

import java.util.List;

public interface BaseGetTListView<V> {
	void getVList(String json,List<V> vList,int status,String msg);
}
