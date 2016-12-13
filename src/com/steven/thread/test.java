package com.steven.thread;
/**
 * ��Java�У�������A������B�е�ĳ������b��Ȼ����B����ĳ��ʱ�򷴹���������A�е�ĳ������a������A��˵�����a����������ص�����
 *
 *
 *
 *��Android��ѧϰ�����о������������߼������ص�������ʣ���ôʲô�ǻص��أ���ν�Ļص��������ǣ���A���ж�����һ������������������õ���һ���ӿں͸ýӿ��еĳ��󷽷���
 *���ǳ��󷽷�û�о����ʵ�֣���ҪB��ȥʵ�֣�B��ʵ�ָ÷�������������ȥ���ø÷��������Ǵ��ݸ�A�࣬��A��ȥ���ã����ֻ��ƾͳ�Ϊ�ص���
 */


/**
 * ����ԱAд��һ�γ��򣨳���a��������Ԥ���лص������ӿڣ�����װ���˸ó���
 * ����ԱBҪ��a�����Լ��ĳ���b�е�һ�����������ǣ���ͨ��a�еĽӿڻص��Լ�b�еķ�����Ŀ�Ĵﵽ��
 */
interface CallBack{   
	public void callbackMethod();              
}

class A implements CallBack{  // Aʵ�ֽӿ�CallBack   
	B b = new B();   
	public void do1(){   
		b.doSomething(this); // A����ʱ����B��doSomething����,�������������
		//B��ȡ��A��������ʱ�ص�A��ʵ�ֵ�CallBack�ӿ��еķ��� 
	}
	public void callbackMethod(){  // ��A��˵���÷������ǻص�����   
		System.out.println("callbackMethod is executing!");                  
	}              
}
class B{   
	public void doSomething(CallBack cb){  // Bӵ��һ������ΪCallBack�ӿ����͵ķ���   
		System.out.println("I am processing my affairs�� ");   
		System.out.println("then, I need invoke callbackMethod��");   
		cb.callbackMethod();   
	}      
}
public class test {
	public static void main(String[] args) {
		A a=new A();
		a.do1();
	}
}
