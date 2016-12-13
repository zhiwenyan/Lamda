package com.steven.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
/**
 * 线程并发库的使用
 *
 */
public class ThreadPool {
	//线程池的概念与Executors类的使用
	public static void main(String[] args) {       
		//固定线程池：创建固定线程数去执行线程的任务，这里创建三个线程
		ExecutorService threadPool = Executors.newFixedThreadPool(3);
		for (int i = 1; i <= 10; i++) {//向池子里扔10个任务
			final int task = i;
			threadPool.execute(new Runnable() {//execute方法表示向池子中扔任务，任务即一个Runnable
				@Override
				public void run() {
					for (int j = 1; j <= 5; j++) { 
						try {
							Thread.sleep(1000);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						System.out.println(Thread.currentThread().getName()
								+ " looping of " + j + " for task of " + task);
					}
				}
			});

		}
		System.out.println("all of 10 tasks have committed!");
		threadPool.shutdown(); //执行完任务后关闭
		//      threadPool.shutdownNow(); //立即关闭
		//缓存的线程池
		//自动根据任务数量来设定线程数去服务，多了就增加线程数，少了就减少线程数
		//这貌似跟一般情况相同，因为一般也是一个线程执行一个任务，但是这里的好处是：如果有个线程死了，它又会产生一个新的来执行任务
		//		ExecutorService threadPool1 = Executors.newCachedThreadPool();
		//		for (int i = 1; i <= 10; i++) {//扔5个任务
		//			final int task = i;
		//			threadPool1.execute(new Runnable() {//向池子中扔任务，任务即一个Runnable
		//				@Override
		//				public void run() {
		//					for (int j = 1; j <= 5; j++) {
		//						try {
		//							Thread.sleep(20);
		//						} catch (InterruptedException e) {
		//							// TODO Auto-generated catch block
		//							e.printStackTrace();
		//						}
		//						System.out.println(Thread.currentThread().getName()
		//								+ " looping of " + j + " for task of " + task);
		//					}
		//				}
		//			});
		//		}
		//		System.out.println("all of 10 tasks have committed!");
		//		threadPool.shutdown(); //执行完任务后关闭
		//
		//		//拿到定时器线程池
		//		ScheduledExecutorService threadPool2 = Executors.newScheduledThreadPool(3);
		//		for(int i = 1; i <= 5; i ++) { //执行5次任务
		//			threadPool2.schedule(new Runnable() {
		//				@Override
		//				public void run() {
		//					try {
		//						Thread.sleep(1000);
		//					} catch (InterruptedException e) {
		//						// TODO Auto-generated catch block
		//						e.printStackTrace();
		//					}
		//					System.out.println(Thread.currentThread().getName() + " bombing");
		//				}
		//			}, 2, TimeUnit.SECONDS);
		//		}   
	}

}
