package com.steven.testClass;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TestClass {
	private String className="com.steven.testClass.Person";
	private void test1(){
		//��һ�ַ�����forName
		try {
			Class<?> class1 = Class.forName(className);
			System.out.println(class1);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		//�ڶ��ŷ�����class
		Class<?> class2 = Person.class;  
		//�����ַ�����getClass
		Person person = new Person();  
		Class<?> class3 = person.getClass();
		System.out.println(class2);
		System.out.println(class3);
	}

	private void test2(){
		try {
			//������
			Class<?> class1 = Class.forName(className);
			//��ȡ���еķ���
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
			//������
			Class<?> class1 = Class.forName(className);
			//��ȡ���еĽӿ�
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
			//������
			Class<?> class1 = Class.forName(className);
			//ȡ�ñ����ȫ������
			Field[] field = class1.getDeclaredFields();
			for (Field field2 : field) {
				System.out.println( field2 );
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	//ʵս1��ͨ�����䣬��ȡ����ʵ�������Ҳ�������ķ���
	private void test6(){
		try {
			//������
			Class<?> class1 = Class.forName(className);
			//����ʵ��
			Object person = class1.newInstance();
			//���id ����
			Field idField = class1.getDeclaredField("id");
			idField.setAccessible(true);
			//��id ���Ը�ֵ
			idField.set(person,"100") ;
			//��ӡ person ������ֵ
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
	//ͨ�������ȡ�����ֶ����ԣ����Ҹ�ֵ
	private void test7(){
		try {
			//������
			Class<?> class1 = Class.forName(className);
			//����ʵ��
			Object person = class1.newInstance();
			//���id ����
			Field idField = class1.getDeclaredField("id") ;
			//���Ʒ�װ  ʵ����setAccessible�����úͽ��÷��ʰ�ȫ���Ŀ���,������Ϊtrue���ܷ���Ϊfalse�Ͳ��ܷ���  
			//����JDK�İ�ȫ����ʱ�϶�.����ͨ��setAccessible(true)�ķ�ʽ�رհ�ȫ���Ϳ��Դﵽ���������ٶȵ�Ŀ��  
			idField.setAccessible(true);
			//��id ���Ը�ֵ
			idField.set(person,"100") ;
			//��ӡ person ������ֵ
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
	//ͨ�������ȡ�����ֶ����ԣ����Ҹ�ֵ
	private void test8(){
		try {
			//������
			Class<?> class1 = Class.forName(className);
			//����ʵ��
			Object person = class1.newInstance();
			//���id ����
			Field idField = class1.getDeclaredField("id") ;
			//���Ʒ�װ  ʵ����setAccessible�����úͽ��÷��ʰ�ȫ���Ŀ���,������Ϊtrue���ܷ���Ϊfalse�Ͳ��ܷ���  
			//����JDK�İ�ȫ����ʱ�϶�.����ͨ��setAccessible(true)�ķ�ʽ�رհ�ȫ���Ϳ��Դﵽ���������ٶȵ�Ŀ��  
			idField.setAccessible(true);
			//��id ���Ը�ֵ
			idField.set(person,"100") ;
			//��ȡ setName() ����
			Method setName = class1.getDeclaredMethod("setName", String.class ) ;
			//���Ʒ�װ 
			setName.setAccessible(true);
			//����setName ������
			setName.invoke(person ,"jack") ;
			//��ȡname �ֶ�
			Field nameField = class1.getDeclaredField( "name" ) ;
			//���Ʒ�װ 
			nameField.setAccessible( true );
			//��ӡ person �� id ����ֵ
			String id_ = (String) idField.get(person) ;
			System.out.println( "id: " + id_);
			//��ӡ person �� name ����ֵ
			String name_ = (String)nameField.get( person ) ;
			System.out.println( "name: " + name_ );
			//��ȡ getName ����
			Method getName = class1.getDeclaredMethod("getName") ;
			//���Ʒ�װ 
			getName.setAccessible( true );
			//ִ��getName���������ҽ��շ���ֵ
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
		System.out.println("---�ӿ�");
		tc.test3();
		tc.test5();
		System.out.println("---ͨ�����䣬��ȡ����ʵ�������Ҳ�������ķ���");
		tc.test6();
		System.out.println("---ͨ�������ȡ�����ֶ����ԣ����Ҹ�ֵ");
		tc.test7();
		tc.test8();
	}
}
