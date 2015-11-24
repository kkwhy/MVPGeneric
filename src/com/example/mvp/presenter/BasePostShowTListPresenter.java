package com.example.mvp.presenter;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

import android.os.Handler;
import android.os.Looper;

import com.example.mvp.bean.response.BaseResponseBean;
import com.example.mvp.bean.response.BaseResponseListBean;
import com.example.mvp.model.BaseModel;
import com.example.mvp.model.impl.BaseModelImpl;
import com.example.mvp.view.BasePostTListView;
import com.example.mvp.view.BasePostTView;
import com.google.gson.Gson;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

public class BasePostShowTListPresenter<T,V> {
	private BaseModel<T> mPostModel;
	private BasePostTListView<V> mPostView;
	
	private final Handler handler;

	private String rp = "";
	Gson gson = new Gson();
	
	private BaseResponseListBean<V> mPostRsp = new BaseResponseListBean<V>();
	
	public BasePostShowTListPresenter(BasePostTListView<V> mPostView){
		this.mPostView = mPostView;
		this.mPostModel = new BaseModelImpl<T>();
		this.handler = new Handler(Looper.getMainLooper());
	}
	/*
	 * 必须有k这个参数，没有实际值的话就为空
	 */
	public void post(final String url,final T t,final Type type) {		
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
	  			mPostRsp = gson.fromJson(rp, type);
	  			
	  			handler.post(new Runnable() {
	  		      @Override public void run() {
	  	  			showPost();
	  		      }
	  		    });
	  		}
		};
		mPostModel.post(url, t, cb);
	}
	
	public void postList(final String url,final List<T> tList,final Type type){
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
	  			mPostRsp = gson.fromJson(rp, type);
	  			
	  			handler.post(new Runnable() {
	  		      @Override public void run() {
	  	  			showPost();
	  		      }
	  		    });
	  		}
		};
		mPostModel.postList(url, tList, cb);
	}
	
	private void showPost(){
		mPostView.postVList(rp, mPostRsp.getData(), mPostRsp.getStatus(), mPostRsp.getMsg());
	}
}
