package com.steven.test;

import java.util.concurrent.FutureTask;

interface Person<V>{
	void cancel();
	V get();
}

class PersonTest<V> implements Person<V>{
	@SuppressWarnings("unchecked")
	private V obj=(V) "s";
	@Override
	public void cancel() {
		System.out.println("cancel");
	}

	@Override
	public V get() {
		return obj;
	}
}
class Person1<V>{
	public PersonTest<V> geTest(){
		return new PersonTest<V>();

	}
}
public class test {
	public static void main(String[] args) {
		Person1<String> mPerson=new Person1<String>();
		Person<String> personTest=mPerson.geTest();
		personTest.cancel();
		System.out.println(personTest.get());
	}
}
