package com.steven.thread;

//有两个线程，子线程先执行10次，然后主线程执行5次，然后再切换到子线程执行10，再主线程执行5次……如此往返执行50次。
/**
 * 
 *线程间通信
 */
class  BusinessNotify{
	private boolean isStart=true;
	public synchronized void sub(int m){
		while(!isStart){
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}	
		}
		for(int i=0;i<10;i++){
			System.out.println("子线程在执行--"+i);
		}
		isStart=false;
		this.notify();
	}
	public synchronized void main(int n){
		while(isStart){
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		for(int i=0;i<5;i++){
			System.out.println("主线程在执行--"+n);
		}
		isStart=true;
		this.notify();
	}
}

public class ThreadNotiy {
	public static void main(String[] args) {
		BusinessNotify notify=new BusinessNotify();
		new Thread(new Runnable() {
			@Override
			public void run() {
				for(int i=0;i<50;i++){
					notify.sub(i);
				}
			}
		}).start();
		for(int i=0;i<50;i++){
			notify.main(i);
		}
	}
}
