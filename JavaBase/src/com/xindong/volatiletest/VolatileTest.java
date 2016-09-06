package com.xindong.volatiletest;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 
 * @author wangjinliang
 *
 */
public class VolatileTest {
//	private int inc = 0;
	
	private AtomicInteger inc = new AtomicInteger(0);
	
//	private volatile int inc = 0;
	
//	private void increase() {
//		inc ++ ;
//	}
	
	private void increase() {
		inc.getAndIncrement();
	}
	
//	private Lock lock = new ReentrantLock();
//	private void increase() {
//		lock.lock();
//		inc ++ ;
//		lock.unlock();
//	}
	
//	private synchronized void increase() {
//		inc ++ ;
//	}
	
	public static void main(String[] args) {
		VolatileTest test = new VolatileTest();
		for (int i=0; i<10; i++) {
			new Thread(new Runnable() {
				
				@Override
				public void run() {
					for (int j=0; j<1000; j++) {
						test.increase();
					}
				}
			}).start();
		}
		
		while(Thread.activeCount() > 1) {
			Thread.yield();
		}
		System.out.println("increase: " + test.inc);
	}
}
