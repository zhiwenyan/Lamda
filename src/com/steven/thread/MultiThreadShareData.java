package com.steven.thread;
/***
 * ����̼߳乲������
 *
 */
public class MultiThreadShareData {
	public static void main(String[] args) {
		ShareData task = new ShareData(); //�������ݺ��������task��
		for(int i = 0; i < 2; i ++) { //���������߳�����data
			new Thread(new Runnable() {
				@Override
				public void run() {
					task.increment();
				}
			}).start();
		}
		for(int i = 0; i < 2; i ++) { //���������̼߳���data
			new Thread(new Runnable() {
				@Override
				public void run() {
					task.decrement();
				}
			}).start();
		}           
	}
}   
class ShareData /*implements Runnable*/ {
	private int data = 0;
	public synchronized void increment() { //����data
		System.out.println(Thread.currentThread().getName() + ": before : " + data);
		data++;
		System.out.println(Thread.currentThread().getName() + ": after : " + data);
	}

	public synchronized void decrement() { //����data
		System.out.println(Thread.currentThread().getName() + ": before : " + data);
		data--;
		System.out.println(Thread.currentThread().getName() + ": after : " + data);
	}
}
