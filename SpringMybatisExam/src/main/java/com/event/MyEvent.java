package com.event;

import org.springframework.context.ApplicationEvent;

public class MyEvent extends ApplicationEvent {
	
	/**
	 * 定义事件类
	 */
	private static final long serialVersionUID = 1L;
	private String methodName;

	public MyEvent(Object source) {
		super(source);
	}
	
	public MyEvent(Object source,String methodName){
		super(source);
		this.methodName = methodName;
	}
	public String getMethodName() {
		return methodName;
	}

	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}
}
