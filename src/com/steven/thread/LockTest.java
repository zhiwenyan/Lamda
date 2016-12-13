package com.steven.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 同步锁的技术
 *
 */
public class LockTest {
	public static void main(String[] args) {
		new LockTest().init();
	}
	private void init() {
		final Outputer outputer = new Outputer();
		// 线程1打印：duoxiancheng
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
		// 线程2打印：eson15
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

	// 自定义一个类，保存锁和待执行的任务
	static class Outputer {
		Lock lock = new ReentrantLock(); //定义一个锁，Lock是个接口，需实例化一个具体的Lock
		public void output(String name) {
			int len = name.length();
			lock.lock();
			try {
				for (int i = 0; i < len; i++) {
					System.out.print(name.charAt(i));
				}
				System.out.println("");
			} finally {
				lock.unlock(); //释放锁
			}
		}
	}
}
