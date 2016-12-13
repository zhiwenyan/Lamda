package com.steven.thread;

public class TraditionalThread {


	public static void main(String[] args) {
		new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("Runnable:" + Thread.currentThread().getName());
			}
		}){
			@Override
			public void run() {
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("Thread:" + Thread.currentThread().getName());
			}
		}.start();
	}

}