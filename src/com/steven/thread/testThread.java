package com.steven.thread;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class testThread {
	private Callable<Integer> callable;
	private ExecutorService executorService=Executors.newCachedThreadPool();
	private Future<Integer> task;
	private Future<Integer> task1;
	private  int i,j;
	private void startThread1(){
		callable=new Callable<Integer>() {
			@Override
			public Integer call() throws Exception {
				for ( i = 0; i <10; i++) {
					Thread.sleep(1000);
					System.out.println("startThread1--"+i);
				}
				return i;
			}
		};
		task=executorService.submit(callable);

	}
	private void startThread2(){
		callable=new Callable<Integer>() {
			@Override
			public Integer call() throws Exception {
				for (j = 0; j <10; j++) {
					Thread.sleep(1000);
					if(j==5){
						stopThread2();
					}
					System.out.println("startThread2---"+i);	
				}
				return 10;
			}
		};

		task1=executorService.submit(callable);	
	}
	private void stopThread1(){
		if(task!=null&&!executorService.isShutdown()){
			task.cancel(true);
			System.out.println("线程1停止了");

		}

	}
	private void stopThread2(){
		if(task1!=null&&!executorService.isShutdown()){
			task1.cancel(true);
			System.out.println("线程2停止了");
		}
	}
	private void stopAllThread(){
		if(executorService!=null&&!executorService.isShutdown()){
			//stopThread1();
			//stopThread2();
			executorService.shutdownNow();
			System.out.println("所有线程都停止了");
		}
	}
	public static void main(String[] args) {
		testThread t1=new testThread();
		t1.startThread1();
		t1.startThread2();
	}
}
