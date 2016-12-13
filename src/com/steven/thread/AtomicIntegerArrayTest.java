package com.steven.thread;

import java.util.concurrent.atomic.AtomicIntegerArray;

public class AtomicIntegerArrayTest {
	/**
	 * �����ķ����б�
	 * @see AtomicIntegerArray#addAndGet(int, int) ִ�мӷ�����һ������Ϊ������±꣬�ڶ�������Ϊ���ӵ��������������Ӻ�Ľ��
	 * @see AtomicIntegerArray#compareAndSet(int, int, int) �Ա��޸ģ�����1�������±꣬����2��ԭʼֵ������3���޸�Ŀ��ֵ���޸ĳɹ�����true����false
	 * @see AtomicIntegerArray#decrementAndGet(int) ����Ϊ�����±꣬�������Ӧ���ּ���1�����ؼ��ٺ������
	 * @see AtomicIntegerArray#incrementAndGet(int) ����Ϊ�����±꣬�������Ӧ��������1���������Ӻ������
	 * 
	 * @see AtomicIntegerArray#getAndAdd(int, int) ��addAndGet���ƣ������Ƿ���ֵ�Ǳ仯ǰ������
	 * @see AtomicIntegerArray#getAndDecrement(int) ��decrementAndGet���ƣ������Ƿ��ر仯ǰ������
	 * @see AtomicIntegerArray#getAndIncrement(int) ��incrementAndGet���ƣ������Ƿ��ر仯ǰ������
	 * @see AtomicIntegerArray#getAndSet(int, int) ����Ӧ�±����������Ϊָ��ֵ���ڶ�������Ϊ���õ�ֵ�������Ǳ仯ǰ������
	 */
	private final static AtomicIntegerArray ATOMIC_INTEGER_ARRAY = new AtomicIntegerArray(new int[]{1,2,3,4,5,6,7,8,9,10});
	public static void main(String []args) throws InterruptedException {
		Thread []threads = new Thread[10];
		for(int i = 0 ; i < 10 ; i++) {
			final int index = i;
			final int threadNum = i;
			threads[i] = new Thread() {
				public void run() {
					int result = ATOMIC_INTEGER_ARRAY.addAndGet(index, index + 1);
					System.out.println("�̱߳��Ϊ��" + threadNum + " , ��Ӧ��ԭʼֵΪ��" + (index + 1) + "�����Ӻ�Ľ��Ϊ��" + result);
				}
			};
			threads[i].start();
		}
		for(Thread thread : threads) {
			thread.join();
		}
		System.out.println("=========================>\nִ���Ѿ���ɣ�����б�");
		for(int i = 0 ; i < ATOMIC_INTEGER_ARRAY.length() ; i++) {
			System.out.println(ATOMIC_INTEGER_ARRAY.get(i));
		}
	}
}
