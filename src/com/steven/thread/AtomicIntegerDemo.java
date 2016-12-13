package com.steven.thread;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerDemo {
	/**
	 * �����ķ����б�
	 * @see AtomicInteger#get()             ֱ�ӷ���ֵ
	 * @see AtomicInteger#getAndAdd(int)    ����ָ�������ݣ����ر仯ǰ������
	 * @see AtomicInteger#getAndDecrement() ����1�����ؼ���ǰ������
	 * @see AtomicInteger#getAndIncrement() ����1����������ǰ������
	 * @see AtomicInteger#getAndSet(int)    ����ָ�������ݣ���������ǰ������
	 * 
	 * @see AtomicInteger#addAndGet(int)    ����ָ�������ݺ󷵻����Ӻ������
	 * @see AtomicInteger#decrementAndGet() ����1�����ؼ��ٺ��ֵ
	 * @see AtomicInteger#incrementAndGet() ����1���������Ӻ��ֵ
	 * @see AtomicInteger#lazySet(int)      ������getʱ�Ż�set
	 * 
	 * @see AtomicInteger#compareAndSet(int, int) ����������Աȣ������ӳɹ��򷵻�true���򷵻�false
	 */
	public final static AtomicInteger TEST_INTEGER = new AtomicInteger(0);
	//ԭ���Բ�����ȥ������������int�Ϳ��Խ���̰߳�ȫ����
	//ԭ�Ӳ�����ָһ��������������Ӱ��Ĳ�������Ԫ��ԭ�Ӳ������ڶ��̻߳����±������ݲ�һ�±�����ֶΡ�
	public static void main(String []args) {

		for(int i = 0 ; i < 10 ; i++) { //����10���߳�
			new Thread() {
				public void run() {
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					int now = TEST_INTEGER.incrementAndGet(); //����
					System.out.println(Thread.currentThread().getName() + " get value : " + now);
				}
			}.start();
		}
	}
}
