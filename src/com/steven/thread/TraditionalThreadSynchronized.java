package com.steven.thread;

public class TraditionalThreadSynchronized {
	public static void main(String[] args) {
		//在静态方法中不能new内部类的实例对象
		//private Outputer outputer = new Outputer();
		new TraditionalThreadSynchronized().init();
	}

	private void init() {
		final Outputer outputer = new Outputer();
		//线程1打印：duoxiancheng
		new Thread(new Runnable() {         
			@Override
			public void run() {
				while(true) {
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					outputer.output2("duoxiancheng");
				}

			}
		}).start();;

		//线程2打印：eson15
		new Thread(new Runnable() {         
			@Override
			public void run() {
				while(true) {
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					outputer.output1("eson15");
				}

			}
		}).start();;
	}


	static class Outputer {
		private String token = ""; //定义一个锁
		public void output1(String name) {
			synchronized(this) //任何一个对象都可以作为参数，但是该对象对于两个线程来说是同一个才行
			{
				int len = name.length();
				for(int i = 0; i < len; i++) {
					System.out.print(name.charAt(i));
				}
				System.out.println("");     
			}
		}   
		/**
		 * synchronized关键字修饰方法的时候，同步锁是this，即等效于代码块synchronized(this) {...}。 
		 *
		 */
		public synchronized void output2(String name) {
			int len = name.length();
			for(int i = 0; i < len; i++) {
				System.out.print(name.charAt(i));
			}
			System.out.println("");     
		}   
	}
	//synchronized关键字修饰static方法的时候，同步锁是该类的字节码对象，即等效于代码
	public static synchronized void output3(String name) {

		int len = name.length();
		for(int i = 0; i < len; i++) {
			System.out.print(name.charAt(i));
		}
		System.out.println("");     

	}
	/**
	 * 同步代码块的锁是任意对象。只要不同的线程都执行同一个同步代码块的时候，这个锁随便设。
同步函数的锁是固定的this。当需要和同步函数中的逻辑实行同步的时候，代码块中的锁必须为this。
静态同步函数的锁是该函数所属类的字节码文件对象。该对象可以用this.getClass()方法获取，也可以使用 当前类名.class 表示。
	 */
}
