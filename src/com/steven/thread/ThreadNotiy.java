package com.steven.thread;

//�������̣߳����߳���ִ��10�Σ�Ȼ�����߳�ִ��5�Σ�Ȼ�����л������߳�ִ��10�������߳�ִ��5�Ρ����������ִ��50�Ρ�
/**
 * 
 *�̼߳�ͨ��
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
			System.out.println("���߳���ִ��--"+i);
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
			System.out.println("���߳���ִ��--"+n);
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
