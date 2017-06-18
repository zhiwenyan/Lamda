package com.steven.thread;

import java.util.Random;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockTest {

	public static void main(String[] args) {
		final Queue3 q3 = new Queue3(); // ��װ��������ݡ���д���ʹ�ִ�е��������
		for (int i = 0; i < 3; i++) {
			new Thread() { // ���������߳�д����
				public void run() {
					while (true) {
						q3.put(new Random().nextInt(10000));
					}
				}
			}.start();
			new Thread() { // ���������̶߳�����
				public void run() {
					while (true) {
						q3.get();
					}
				}
			}.start();
		}
	}
}

class Queue3 {

	private Object data = null; // ���������
	private ReadWriteLock rwl = new ReentrantReadWriteLock();// �����д��

	// ��ȡ���ݵ����񷽷�
	public void get() {
		rwl.readLock().lock(); // �϶���
		try {
			System.out.println(Thread.currentThread().getName() + ":before read: " + data); // ��֮ǰ��ӡ������ʾ

			Thread.sleep((long) (Math.random() * 1000)); // ˯һ���~

			System.out.println(Thread.currentThread().getName() + ":after read: " + data); // ��֮���ӡ������ʾ
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			rwl.readLock().unlock();// �ͷŶ���
		}
	}

	// д���ݵ����񷽷�
	public void put(Object data) {
		rwl.writeLock().lock(); // ��д��
		try {
			System.out.println(Thread.currentThread().getName() + ":before write: " + this.data); // ��֮ǰ��ӡ������ʾ

			Thread.sleep((long) (Math.random() * 1000)); // ˯һ���~
			this.data = data; // д����

			System.out.println(Thread.currentThread().getName() + ":after write: " + this.data); // ��֮���ӡ������ʾ
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			rwl.writeLock().unlock();// �ͷ�д��
		}
	}

}
