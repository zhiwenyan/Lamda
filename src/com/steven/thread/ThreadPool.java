package com.steven.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
/**
 * �̲߳������ʹ��
 *
 */
public class ThreadPool {
	//�̳߳صĸ�����Executors���ʹ��
	public static void main(String[] args) {       
		//�̶��̳߳أ������̶��߳���ȥִ���̵߳��������ﴴ�������߳�
		ExecutorService threadPool = Executors.newFixedThreadPool(3);
		for (int i = 1; i <= 10; i++) {//���������10������
			final int task = i;
			threadPool.execute(new Runnable() {//execute������ʾ�����������������һ��Runnable
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
		threadPool.shutdown(); //ִ���������ر�
		//      threadPool.shutdownNow(); //�����ر�
		//������̳߳�
		//�Զ����������������趨�߳���ȥ���񣬶��˾������߳��������˾ͼ����߳���
		//��ò�Ƹ�һ�������ͬ����Ϊһ��Ҳ��һ���߳�ִ��һ�����񣬵�������ĺô��ǣ�����и��߳����ˣ����ֻ����һ���µ���ִ������
		//		ExecutorService threadPool1 = Executors.newCachedThreadPool();
		//		for (int i = 1; i <= 10; i++) {//��5������
		//			final int task = i;
		//			threadPool1.execute(new Runnable() {//�����������������һ��Runnable
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
		//		threadPool.shutdown(); //ִ���������ر�
		//
		//		//�õ���ʱ���̳߳�
		//		ScheduledExecutorService threadPool2 = Executors.newScheduledThreadPool(3);
		//		for(int i = 1; i <= 5; i ++) { //ִ��5������
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
