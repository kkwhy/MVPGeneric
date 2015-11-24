package com.example.mvpgeneric;

import java.lang.reflect.Type;

import com.example.mvp.bean.request.LoginRequestBean;
import com.example.mvp.bean.response.BaseResponseBean;
import com.example.mvp.bean.response.LoginResponseBean;
import com.example.mvp.constants.UrlConstants;
import com.example.mvp.presenter.BasePostShowTPresenter;
import com.example.mvp.view.BasePostTView;
import com.google.gson.reflect.TypeToken;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity 
	implements OnClickListener,BasePostTView<LoginResponseBean>{

	private TextView mTvLogin;
	private TextView mTvResponse;
	
	private BasePostShowTPresenter<LoginRequestBean,LoginResponseBean> mLP;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		initView();
		initPresenter();
		setListener();
	}

	private void initView() {
		mTvLogin = (TextView)findViewById(R.id.tv_login);
		mTvResponse = (TextView)findViewById(R.id.tv_response);
	}
	
	private void initPresenter() {
		mLP = new BasePostShowTPresenter<LoginRequestBean, LoginResponseBean>(this);
	}
	
	private void setListener() {
		mTvLogin.setOnClickListener(this);
	}

	@Override
	public void onClick(View view) {
		switch(view.getId()){
		case R.id.tv_login:
			Toast.makeText(this, "µÇÂ¼ÖÐ", Toast.LENGTH_SHORT).show();
			Type type =  new TypeToken<BaseResponseBean<LoginResponseBean>>(){}.getType();
			mLP.post(UrlConstants.LOGIN_URL,null,type);
			break;
		}
	}

	@Override
	public void postV(String json, LoginResponseBean v, int status, String msg) {
		Toast.makeText(this, json, Toast.LENGTH_SHORT).show();
	}

}
