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
		new Thread(tr,"线程一").start();
		new Thread(tr,"线程二").start();
		new Thread(tr,"线程三").start();
	}
}
