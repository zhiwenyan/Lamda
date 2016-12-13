package com.steven.testClass;

import java.lang.reflect.Field;

public class Test {
	public static void main(String[] args) throws Exception {
		doGet();  
		doReflectGet();  
	}  
	public static void doGet() throws Exception {  
		long start = System.currentTimeMillis();  
		Integer[] arr = new Integer[100000000];  
		A a = new A();  
		for (int i = 0; i < 100000000; i++) {  
            a.getI();  
		}  
		System.out.println(System.currentTimeMillis() - start);  
	}  
	public static void doReflectGet() throws Exception {  
		long start = System.currentTimeMillis();  
		Integer[] arr = new Integer[100000000];  
		A a = new A();  
		Class<A> cls = A.class;  
		Field field = cls.getDeclaredField("i");  
		field.setAccessible(true);
		for (int i = 0; i < 100000000; i++) {  
            field.get(a); 
            
		}  
		System.out.println(System.currentTimeMillis() - start);  
	}  
}

