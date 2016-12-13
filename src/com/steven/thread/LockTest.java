package com.steven.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * ͬ�����ļ���
 *
 */
public class LockTest {
	public static void main(String[] args) {
		new LockTest().init();
	}
	private void init() {
		final Outputer outputer = new Outputer();
		// �߳�1��ӡ��duoxiancheng
		new Thread(new Runnable() {
			@Override
			public void run() {
				while (true) {
					try {
						Thread.sleep(5);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					outputer.output("duoxiancheng");
				}
			}
		}).start();
		// �߳�2��ӡ��eson15
		new Thread(new Runnable() {
			@Override
			public void run() {
				while (true) {
					try {
						Thread.sleep(5);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					outputer.output("eson15");
				}
			}
		}).start();
	}

	// �Զ���һ���࣬�������ʹ�ִ�е�����
	static class Outputer {
		Lock lock = new ReentrantLock(); //����һ������Lock�Ǹ��ӿڣ���ʵ����һ�������Lock
		public void output(String name) {
			int len = name.length();
			lock.lock();
			try {
				for (int i = 0; i < len; i++) {
					System.out.print(name.charAt(i));
				}
				System.out.println("");
			} finally {
				lock.unlock(); //�ͷ���
			}
		}
	}
}
