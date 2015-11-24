package com.example.mvp.model.impl;

import java.util.List;

import android.util.Log;

import com.example.mvp.model.BaseModel;
import com.example.mvp.util.ExecutorServiceManager;
import com.example.mvp.util.OkHttpClientManager;
import com.google.gson.Gson;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.FormEncodingBuilder;
import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;

public class BaseModelImpl<T> implements BaseModel<T> {
	
	public static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");
	
	private OkHttpClientManager okManager = OkHttpClientManager.getInstance();
    private OkHttpClient client = OkHttpClientManager.getClinet();
    private ExecutorServiceManager excutorServiceManager = ExecutorServiceManager.getInstance();
	
	
	@Override
	public void get(final String url, final Callback cb) {
		Thread thread = new Thread(new Runnable(){
			@Override
			public void run() {
				Request request = new Request.Builder().url(url)
				.get()
				.build();
				client.newCall(request).enqueue(cb);
			}
		});
		
		excutorServiceManager.getExecutor().execute(thread);
	}

	@Override
	public void post(final String url, final T t, final Callback cb) {
		Thread thread = new Thread(new Runnable(){
			@Override
			public void run() {
				RequestBody body;
				if(t==null){
					body = new FormEncodingBuilder()
					.build();//post 不带参数
				}else{
					body = RequestBody.create(JSON, new Gson().toJson(t));  // post 带参数
				}
				Request request = new Request.Builder().url(url)
				.post(body)
				.build();
				client.newCall(request).enqueue(cb);
			}
		});
		
		excutorServiceManager.getExecutor().execute(thread);
	}

	/*
	 * (non-Javadoc)
	 * request 提交的是一个post
	 * @see com.example.mvp.model.BaseModel#postList(java.lang.String, java.util.List, com.squareup.okhttp.Callback)
	 */
	@Override
	public void postList(final String url, final List<T> tList, final Callback cb) {
		Thread thread = new Thread(new Runnable(){
			@Override
			public void run() {
				RequestBody body;
				if(tList==null){
					body = new FormEncodingBuilder()
					.build();//post 不带参数
				}else{
					body = RequestBody.create(JSON, new Gson().toJson(tList));  // post 带参数
				}
				Request request = new Request.Builder().url(url)
				.post(body)
				.build();
				client.newCall(request).enqueue(cb);
			}
		});
		
		excutorServiceManager.getExecutor().execute(thread);
	}

	@Override
	public void delete(final String url, final T t, final Callback cb) {
		Thread thread = new Thread(new Runnable(){
			@Override
			public void run() {
				RequestBody body;
				if(t==null){
					body = new FormEncodingBuilder()
					.build();//post 不带参数
				}else{
					body = RequestBody.create(JSON, new Gson().toJson(t));  // post 带参数
				}
				Request request = new Request.Builder().url(url)
				.delete(body)
				.build();
				client.newCall(request).enqueue(cb);
			}
		});
		
		excutorServiceManager.getExecutor().execute(thread);
	}

	@Override
	public void deleteList(final String url, final List<T> tList, final Callback cb) {
		Thread thread = new Thread(new Runnable(){
			@Override
			public void run() {
				RequestBody body;
				if(tList==null){
					body = new FormEncodingBuilder()
					.build();//post 不带参数
				}else{
					body = RequestBody.create(JSON, new Gson().toJson(tList));  // post 带参数
				}
				Request request = new Request.Builder().url(url)
				.delete(body)
				.build();
				client.newCall(request).enqueue(cb);
			}
		});
		
		excutorServiceManager.getExecutor().execute(thread);
	}

	@Override
	public void put(final String url, final T t, final Callback cb) {
		Thread thread = new Thread(new Runnable(){
			@Override
			public void run() {
				RequestBody body;
				if(t==null){
					body = new FormEncodingBuilder()
					.build();//post 不带参数
				}else{
					body = RequestBody.create(JSON, new Gson().toJson(t));  // post 带参数
				}
				Request request = new Request.Builder().url(url)
				.put(body)
				.build();
				client.newCall(request).enqueue(cb);
			}
		});
		
		excutorServiceManager.getExecutor().execute(thread);
	}

	@Override
	public void putList(final String url, final List<T> tList, final Callback cb) {
		Thread thread = new Thread(new Runnable(){
			@Override
			public void run() {
				RequestBody body;
				if(tList==null){
					body = new FormEncodingBuilder()
					.build();//post 不带参数
				}else{
					body = RequestBody.create(JSON, new Gson().toJson(tList));  // post 带参数
				}
				Request request = new Request.Builder().url(url)
				.put(body)
				.build();
				client.newCall(request).enqueue(cb);
			}
		});
		
		excutorServiceManager.getExecutor().execute(thread);
	}

}
