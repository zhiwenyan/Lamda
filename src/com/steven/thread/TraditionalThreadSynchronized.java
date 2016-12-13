package com.steven.thread;

public class TraditionalThreadSynchronized {
	public static void main(String[] args) {
		//�ھ�̬�����в���new�ڲ����ʵ������
		//private Outputer outputer = new Outputer();
		new TraditionalThreadSynchronized().init();
	}

	private void init() {
		final Outputer outputer = new Outputer();
		//�߳�1��ӡ��duoxiancheng
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

		//�߳�2��ӡ��eson15
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
		private String token = ""; //����һ����
		public void output1(String name) {
			synchronized(this) //�κ�һ�����󶼿�����Ϊ���������Ǹö�����������߳���˵��ͬһ������
			{
				int len = name.length();
				for(int i = 0; i < len; i++) {
					System.out.print(name.charAt(i));
				}
				System.out.println("");     
			}
		}   
		/**
		 * synchronized�ؼ������η�����ʱ��ͬ������this������Ч�ڴ����synchronized(this) {...}�� 
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
	//synchronized�ؼ�������static������ʱ��ͬ�����Ǹ�����ֽ�����󣬼���Ч�ڴ���
	public static synchronized void output3(String name) {

		int len = name.length();
		for(int i = 0; i < len; i++) {
			System.out.print(name.charAt(i));
		}
		System.out.println("");     

	}
	/**
	 * ͬ�������������������ֻҪ��ͬ���̶߳�ִ��ͬһ��ͬ��������ʱ�����������衣
ͬ�����������ǹ̶���this������Ҫ��ͬ�������е��߼�ʵ��ͬ����ʱ�򣬴�����е�������Ϊthis��
��̬ͬ�����������Ǹú�����������ֽ����ļ����󡣸ö��������this.getClass()������ȡ��Ҳ����ʹ�� ��ǰ����.class ��ʾ��
	 */
}
