package com.event;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

public class EventListener implements ApplicationListener<ApplicationEvent> {

	public void onApplicationEvent(ApplicationEvent event) {
		if (event instanceof MyEvent) {
			MyEvent event2 = (MyEvent) event;
			System.out.println("执行自定义事件："+event2.getMethodName());
		}
	}

}
