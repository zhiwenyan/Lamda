package com.steven.lamda;


public class TestThread implements Runnable{
	int num=3;
	@Override
	public void run() {
		for(int i=0;i<10;i++){
			if(this.num>0){
				System.out.println(Thread.currentThread().getName()+"-->"+num--);
			}
		}
	}
	public static void main(String[] args) {
		TestThread tr=new TestThread();
		new Thread(tr,"�߳�һ").start();
		new Thread(tr,"�̶߳�").start();
		new Thread(tr,"�߳���").start();
	}
}
