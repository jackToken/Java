package com.xindong.volatiletest;

/**
 * double detect(Single instance)
 * @author wangjinliang
 *
 */
public class SingleInstance {
	private volatile static SingleInstance instance = null;
	
//	public synchronized static SingleInstance getInstance() {
//		if (instance == null) {
//			instance = new SingleInstance();
//		}
//		return instance;
//	}
	
	public static SingleInstance getInstance() {
		if (instance == null) {
			synchronized (SingleInstance.class) {
				if (instance == null) {
					instance = new SingleInstance();
				}
			}
		}
		return instance;
	}
}
