package com.event;

import org.aspectj.lang.JoinPoint;

public class SelectAspect {
	
	public void beforeInsertEvent(JoinPoint joint){
		String methodName = joint.getSignature().getName();
		System.out.println("the method:" + methodName + " is begin");
		System.out.println("  Begin Insert Customer Data");
	}
	
	public void afterInsertEvent(JoinPoint joint){
		String methodName = joint.getSignature().getName();
		System.out.println("the method:" + methodName + " is end");
		System.out.println("  After Insert Customer Data");
	}
}
