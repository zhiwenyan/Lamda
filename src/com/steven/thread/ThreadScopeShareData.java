package com.steven.thread;

import java.util.Random;

public class ThreadScopeShareData {
	//线程范围内共享数据
	private static int data = 0;//公共的数据
	public static void main(String[] args) {
		for(int i = 0; i < 2; i ++) { //开启两个线程
			new Thread(new Runnable() {
				@Override
				public void run() {
					int temp = new Random().nextInt();
					System.out.println(Thread.currentThread().getName() + " has put a data: " + temp); //打印出来为了看效果
					data = temp; //操作数据：赋新值
					new TestA().getData();
					new TestB().getData();
				}
			}).start();
		}
	}
	static class TestA {
		public  void getData() {
			System.out.println("A get data from " + Thread.currentThread().getName() + ": " + data);//取出公共数据data
		}
	}
	static class TestB {
		public  void getData() {
			System.out.println("B get data from " + Thread.currentThread().getName() + ": " + data);
		}
	}
}
