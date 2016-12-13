package com.steven.testClass;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TestClass {
	private String className="com.steven.testClass.Person";
	private void test1(){
		//第一种方法：forName
		try {
			Class<?> class1 = Class.forName(className);
			System.out.println(class1);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		//第二张方法：class
		Class<?> class2 = Person.class;  
		//第三种方法：getClass
		Person person = new Person();  
		Class<?> class3 = person.getClass();
		System.out.println(class2);
		System.out.println(class3);
	}

	private void test2(){
		try {
			//创建类
			Class<?> class1 = Class.forName(className);
			//获取所有的方法
			Method[] methods =  class1.getMethods() ;
			for (Method method : methods) {
				System.out.println( method );
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	private void test3(){
		try {
			//创建类
			Class<?> class1 = Class.forName(className);
			//获取所有的接口
			Class<?>[] interS = class1.getInterfaces() ;
			for (Class<?> class2 : interS ) {
				System.out.println( class2 );
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	private void  test5(){
		try {
			//创建类
			Class<?> class1 = Class.forName(className);
			//取得本类的全部属性
			Field[] field = class1.getDeclaredFields();
			for (Field field2 : field) {
				System.out.println( field2 );
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	//实战1：通过反射，获取对象实例，并且操作对象的方法
	private void test6(){
		try {
			//创建类
			Class<?> class1 = Class.forName(className);
			//创建实例
			Object person = class1.newInstance();
			//获得id 属性
			Field idField = class1.getDeclaredField("id");
			idField.setAccessible(true);
			//给id 属性赋值
			idField.set(person,"100") ;
			//打印 person 的属性值
			System.out.println( idField.get(person));

		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace() ;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	//通过反射获取对象字段属性，并且赋值
	private void test7(){
		try {
			//创建类
			Class<?> class1 = Class.forName(className);
			//创建实例
			Object person = class1.newInstance();
			//获得id 属性
			Field idField = class1.getDeclaredField("id") ;
			//打破封装  实际上setAccessible是启用和禁用访问安全检查的开关,并不是为true就能访问为false就不能访问  
			//由于JDK的安全检查耗时较多.所以通过setAccessible(true)的方式关闭安全检查就可以达到提升反射速度的目的  
			idField.setAccessible(true);
			//给id 属性赋值
			idField.set(person,"100") ;
			//打印 person 的属性值
			System.out.println(idField.get(person));
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace() ;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	//通过反射获取对象字段属性，并且赋值
	private void test8(){
		try {
			//创建类
			Class<?> class1 = Class.forName(className);
			//创建实例
			Object person = class1.newInstance();
			//获得id 属性
			Field idField = class1.getDeclaredField("id") ;
			//打破封装  实际上setAccessible是启用和禁用访问安全检查的开关,并不是为true就能访问为false就不能访问  
			//由于JDK的安全检查耗时较多.所以通过setAccessible(true)的方式关闭安全检查就可以达到提升反射速度的目的  
			idField.setAccessible(true);
			//给id 属性赋值
			idField.set(person,"100") ;
			//获取 setName() 方法
			Method setName = class1.getDeclaredMethod("setName", String.class ) ;
			//打破封装 
			setName.setAccessible(true);
			//调用setName 方法。
			setName.invoke(person ,"jack") ;
			//获取name 字段
			Field nameField = class1.getDeclaredField( "name" ) ;
			//打破封装 
			nameField.setAccessible( true );
			//打印 person 的 id 属性值
			String id_ = (String) idField.get(person) ;
			System.out.println( "id: " + id_);
			//打印 person 的 name 属性值
			String name_ = (String)nameField.get( person ) ;
			System.out.println( "name: " + name_ );
			//获取 getName 方法
			Method getName = class1.getDeclaredMethod("getName") ;
			//打破封装 
			getName.setAccessible( true );
			//执行getName方法，并且接收返回值
			String name_2 = (String) getName.invoke(person) ;
			System.out.println( "name2: " + name_2);
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace() ;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		TestClass tc=new TestClass();
		tc.test1();
		tc.test2();
		System.out.println("---接口");
		tc.test3();
		tc.test5();
		System.out.println("---通过反射，获取对象实例，并且操作对象的方法");
		tc.test6();
		System.out.println("---通过反射获取对象字段属性，并且赋值");
		tc.test7();
		tc.test8();
	}
}
