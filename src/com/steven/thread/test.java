package com.steven.thread;
/**
 * 在Java中，就是类A调用类B中的某个方法b，然后类B又在某个时候反过来调用类A中的某个方法a，对于A来说，这个a方法便叫做回调方法
 *
 *
 *
 *在Android的学习过程中经常会听到或者见到“回调”这个词，那么什么是回调呢？所谓的回调函数就是：在A类中定义了一个方法，这个方法中用到了一个接口和该接口中的抽象方法，
 *但是抽象方法没有具体的实现，需要B类去实现，B类实现该方法后，它本身不会去调用该方法，而是传递给A类，供A类去调用，这种机制就称为回调。
 */


/**
 * 程序员A写了一段程序（程序a），其中预留有回调函数接口，并封装好了该程序。
 * 程序员B要让a调用自己的程序b中的一个方法，于是，他通过a中的接口回调自己b中的方法。目的达到。
 */
interface CallBack{   
	public void callbackMethod();              
}

class A implements CallBack{  // A实现接口CallBack   
	B b = new B();   
	public void do1(){   
		b.doSomething(this); // A运行时调用B中doSomething方法,以自身传入参数，
		//B已取得A，可以随时回调A所实现的CallBack接口中的方法 
	}
	public void callbackMethod(){  // 对A来说，该方法就是回调方法   
		System.out.println("callbackMethod is executing!");                  
	}              
}
class B{   
	public void doSomething(CallBack cb){  // B拥有一个参数为CallBack接口类型的方法   
		System.out.println("I am processing my affairs… ");   
		System.out.println("then, I need invoke callbackMethod…");   
		cb.callbackMethod();   
	}      
}
public class test {
	public static void main(String[] args) {
		A a=new A();
		a.do1();
	}
}
