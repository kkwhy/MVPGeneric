package com.example.mvp.util;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/*
 * ï¿½ï¿½ï¿½Ì»ï¿½ï¿½ï¿½ï¿?
 */
public class ExecutorServiceManager {
	private static ExecutorServiceManager mInstance;
	
	private ExecutorService executor;
	
	private ExecutorServiceManager(){
		this.executor = Executors.newFixedThreadPool(6);  
	}
	
	public static ExecutorServiceManager getInstance()
    {
        if (mInstance == null)
        {
            synchronized (ExecutorServiceManager.class)
            {
                if (mInstance == null)
                {
                    mInstance = new ExecutorServiceManager();
                }
            }
        }
        return mInstance;
    }

	public ExecutorService getExecutor() {
		return executor;
	}

	public void setExecutor(ExecutorService executor) {
		this.executor = executor;
	}
	
}
