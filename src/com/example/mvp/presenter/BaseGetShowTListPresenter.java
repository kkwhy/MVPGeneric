package com.example.mvp.presenter;

import java.io.IOException;
import java.lang.reflect.Type;

import android.os.Handler;
import android.os.Looper;

import com.example.mvp.bean.response.BaseResponseBean;
import com.example.mvp.bean.response.BaseResponseListBean;
import com.example.mvp.model.BaseModel;
import com.example.mvp.model.impl.BaseModelImpl;
import com.example.mvp.view.BaseGetTListView;
import com.example.mvp.view.BaseGetTView;
import com.google.gson.Gson;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

public class BaseGetShowTListPresenter<T,V> {
	private BaseModel<T> mGetModel;
	private BaseGetTListView<V> mGetView;
	
	private final Handler handler;

	private String rp = "";
	Gson gson = new Gson();
	
	private BaseResponseListBean<V> mGetRsp = new BaseResponseListBean<V>();
	
	public BaseGetShowTListPresenter(BaseGetTListView<V> mGetView){
		this.mGetView = mGetView;
		this.mGetModel = new BaseModelImpl<T>();
		this.handler = new Handler(Looper.getMainLooper());
	}
	/*
	 * 必须有k这个参数，没有实际值的话就为空
	 */
	public void Get(final String url,final T t,final Type type) {		
		Callback cb = new Callback() {
	  		@Override
	  		public void onFailure(Request request, IOException e) {
	  			e.printStackTrace();
	  		}

	  		@Override
	  		public void onResponse(Response response) throws IOException {
	  			if (!response.isSuccessful()) {
	  				throw new IOException("Unexpected code " + response);
	  			}
	  			
	  			rp = response.body().string();
//	  			Type type = new TypeToken<BaseResponseBean<V>>(){}.getType();  type由所在的activity进行传递
	  			mGetRsp = gson.fromJson(rp, type);
	  			
	  			handler.post(new Runnable() {
	  		      @Override public void run() {
	  	  			showGet();
	  		      }
	  		    });
	  		}
		};
		mGetModel.get(url, cb);
	}
	
	
	private void showGet(){
		mGetView.getVList(rp, mGetRsp.getData(), mGetRsp.getStatus(), mGetRsp.getMsg());
	}
}
