package com.example.mvp.view;

import java.util.List;

public interface BasePostTListView<V> {
	void postVList(String json,List<V> vList,int status,String msg);
}
