package com.steven.thread;
class Business { //��������������������
	//����������
	public static final Object lock_a = new Object();
	public static final Object lock_b = new Object();   

	public void functionA() {
		synchronized(lock_a) {
			System.out.println("---ThreadA---lock_a---");
			synchronized(lock_b) {
				System.out.println("---ThreadA---lock_b---");
			}
		}
	}
	public void functionB() {
		synchronized(lock_b) {
			System.out.println("---ThreadB---lock_b---");
			synchronized(lock_a) {
				System.out.println("---ThreadB---lock_a---");
			}
		}
	}
}

public class DeadLock {

	public static void main(String[] args) {
		Business business = new Business();
		//����һ���߳�ִ��Business���е�functionA����
		new Thread(new Runnable() {

			@Override
			public void run() {
				while(true) {
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					business.functionA();
				}
			}
		}).start();

		//������һ���߳�ִ��Business���е�functionB����
		new Thread(new Runnable() {

			@Override
			public void run() {

				while(true) {
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					business.functionB();
				}
			}
		}).start();

	}


}
