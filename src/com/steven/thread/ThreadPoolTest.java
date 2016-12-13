package com.steven.thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
public class ThreadPoolTest {
	public static void main(String[] args) {
		ThreadFactory threadFactory = Executors.defaultThreadFactory();
		ThreadPoolExecutor executor = new ThreadPoolExecutor(2, 5, 200, TimeUnit.SECONDS, 
				new ArrayBlockingQueue<Runnable>(5), threadFactory,new RejectedExecutionHandlerImpl());
		for(int i=0;i<10;i++){
			executor.execute(new Runnable() {				
				@Override
				public void run() {
					for(int j=0;j<2;j++){
						try {
							Thread.sleep(1000);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						System.out.println("线程池中线程数目：" + executor.getPoolSize() + "，队列中等待执行的任务数目：" +
								executor.getQueue().size() + "，已执行玩别的任务数目：" + executor.getCompletedTaskCount());
					}
				}
			});
		}
		executor.shutdown();
	}
	static class  RejectedExecutionHandlerImpl  implements RejectedExecutionHandler{
		@Override
		public void rejectedExecution(Runnable arg0, ThreadPoolExecutor arg1) {
			System.out.println(arg0+","+arg1);
		}
	}
}
