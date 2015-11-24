package com.example.mvp.view;

import java.util.List;

public interface BaseDeleteTListView<V> {
	void deleteVList(String json,List<V> vList,int status,String msg);
}
