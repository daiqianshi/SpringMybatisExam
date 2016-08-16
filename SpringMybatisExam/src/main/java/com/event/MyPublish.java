package com.event;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;

public class MyPublish implements ApplicationEventPublisherAware {
	
	private ApplicationEventPublisher applicationEventPublisher;

	public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
		this.applicationEventPublisher = applicationEventPublisher;
	}
	
	public void beforeInsertFilmEvent(){
		applicationEventPublisher.publishEvent(new MyEvent(this, "---------BeforeInsertFilmEvent--------"));
	}
	public void afterInsertFilmEvent(){
		applicationEventPublisher.publishEvent(new MyEvent(this, "---------AfterInsertFilmEvent---------"));
	}


}
