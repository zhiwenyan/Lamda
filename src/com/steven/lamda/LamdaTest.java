package com.steven.lamda;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import javax.swing.JButton;

public class LamdaTest {
	/**
	 * * �����ʹ�� �����﷨ʵ��Lambda:
(params) -> expression
(params) -> statement
(params) -> { statements }
�����ķ��������ı��κη�������������ֻ���������ô���Լ�д���£�
() -> System.out.println("Hello Lambda Expressions");
�����ķ������������������������£�
(int even, int odd) -> even + odd
	 */
	//1. ʵ��Runnable�̰߳���

	private void test1(){
		new Thread(new  Runnable() {
			public void run() {
				System.out.println("before java8");
			}
		}).start();
		new Thread(() -> System.out.println("In Java8!")).start();
	}
	//2.ʵ���¼�����
	private void test2(){
		//Before Java 8:
		JButton show =  new JButton("Show");
		show.addActionListener(new ActionListener() {    
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("without lambda expression is boring");
			}
		});
		// Java 8 way:
		show.addActionListener((e) -> {System.out.println("Action !! Lambda expressions Rocks");
		});
	}
	//3.ʹ��Lambda���ʽ����List����
	private void test3(){
		//Prior Java 8 :
		List<String> features = Arrays.
				asList("Lambdas", "Default Method", 
						"Stream API", "Date and Time API");
		for (String feature : features) {   
			System.out.print(feature+",");
		}
		System.out.println();
		//In Java 8:
		List<String> features1 = Arrays.
				asList("Lambdas", "Default Method", 
						"Stream API","Date and Time API");
		features1.forEach(str->System.out.print(str+","));
		System.out.println();
	}
	//4.ʹ��Lambda���ʽ�ͺ����ӿ�
	/**
	 * Ϊ��֧�ֺ�����̣�Java 8������һ���µİ�java.util.function��
	 * ������һ���ӿ�java.util.function.Predicate��֧��Lambda������̣�
	 * 
	 */
	private void test4(){
		List<String> languages = Arrays.asList("Java", "Scala",
				"C++", "Haskell", "Lisp");
		System.out.println("Languages which starts with J :");
		filter(languages, (str)->(str).startsWith("J"));

		System.out.println("Languages which ends with a ");
		filter(languages, (str)->(str).endsWith("a"));

		System.out.println("Print all languages :");
		filter(languages, (str)->true);

		System.out.println("Print no language : ");
		filter(languages, (str)->false);

		System.out.println("Print language whose length greater than 4:");
		filter(languages, (str)->(str).length() > 4);
	}
	public static void filter(List<String> names, Predicate<String> condition) {    
		for(String name: names)  {       
			if(condition.test(name)) {
				System.out.println(name + " ");
			}
		}
	}

	private void test5(){
		List<String> names = Arrays.asList("Java", "Scala",
				"C++", "Haskell", "Lisp");
		//	java.util.function.Predicate�ṩand(), or() �� xor()���Խ����߼�����������Ϊ�˵õ�һ���ַ�������"J"��ͷ��4�����ȣ�
		// We can even combine Predicate using and(), or() And xor() logical functions
		// for example to find names, which starts with J and four letters long, you
		// can pass combination of two Predicate
		Predicate<String> startsWithJ = (n) -> n.startsWith("J"); 
		Predicate<String> fourLetterLong = (n) -> n.length() == 4;
		names.stream().
		filter(startsWithJ.and(fourLetterLong)).forEach((n) -> System.out.print("\nName, which starts with'J' "
				+ "and four letter long is : " + n));
		//����startsWithJ.and(fourLetterLong)��ʹ����AND�߼�������
	}
	/*&
	 * �����еĺ�����̸�����map����������ı���Ķ�������������У�
	 * ���ǽ�costBeforeTeax������ÿ��Ԫ�ظı�������һ������ֵ�����ǽ�Lambda���ʽ x ->
	 *  x*x����map()�������⽫Ӧ�õ�stream������Ԫ�ء�Ȼ������ʹ�� forEach() ��ӡ��������ϵ�Ԫ��.
	 */
	//6.ʹ��Lambdaʵ��Map �� Reduce
	private void test6(){
		List<Integer> costBeforeTax = Arrays.asList(100, 200, 300, 400, 500);
		for (Integer cost : costBeforeTax) {
			double price = cost + .12*cost;      
			System.out.println(price);
		}
		// With Lambda expression:
		costBeforeTax.stream().map((cost) -> cost + .12*cost).forEach(System.out::println);
		double total = 0;for (Integer cost : costBeforeTax) {
			double price = cost + .12*cost;
			total = total + price;
		}
		System.out.println("Total : " + total);
		//reduce() �ǽ�����������ֵ��Ͻ�һ����Reduce����SQL����е�sum(), avg() ��count(), 
		// New way:
		double bill = costBeforeTax.stream().map((cost) -> cost + .12*cost).
				reduce((sum, cost) -> sum + cost).get();                                    
		System.out.println("Total : " + bill);
	}

	//7.ͨ��filtering ����һ���ַ���String�ļ���
	private void test7(){
		/**
		 * Filtering�ǶԴ���Collection������һ��ͨ�ò�����Stream�ṩfilter()������
		 * ����һ��Predicate������ζ�����ܴ���lambda���ʽ��Ϊһ�������߼��������������
		 */
		// Create a List with String more than 2 characters
		List<String> strList = Arrays.asList("Java", "Scala",
				"C++", "Haskell", "Lisp");
		List<String> filtered = strList.stream().filter(x -> x.length()> 4).collect(Collectors.toList());
		System.out.printf("Original List : %s, filtered list : %s %n", strList, filtered);
	}
	//8.�Լ�����ÿ��Ԫ��Ӧ�ú���
	private void test8(){
		//���Ǿ�����Ҫ�Լ�����Ԫ������һ���Ĺ��ܣ�����е�ÿ��Ԫ�س��Ի����һ��ֵ�ȵ�.
		// Convert String to Uppercase and join them using coma
		List<String> G7 = Arrays.asList("USA", "Japan", "France", "Germany", "Italy", "U.K.","Canada");
		String G7Countries = G7.stream().map(x -> x.toUpperCase()).collect(Collectors.joining(","));
		System.out.println(G7Countries);
		//�����ǽ��ַ���ת��Ϊ��д��Ȼ��ʹ�ö��Ŵ�������
	}
	private void test9(){
		//ʹ��Stream��distinct()�������˼������ظ�Ԫ�ء�
		// Create List of square of all distinct numbers
		List<Integer> numbers = Arrays.asList(9, 10, 3, 4, 7, 3, 4);
		List<Integer> distinct = numbers.stream().map( i -> i*i).distinct().collect(Collectors.toList());
		System.out.printf("Original List : %s,  Square Without duplicates :%s %n", numbers, distinct);

	}
	//10.����List�е�Ԫ�ص����ֵ����Сֵ���ܺͼ�ƽ��ֵ
	private void test10(){
		//Get count, min, max, sum, and average for numbers
		List<Integer> primes = Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19, 23, 29);
		IntSummaryStatistics stats = primes.stream().mapToInt((x) -> x).summaryStatistics();
		System.out.println("Highest prime number in List : " + stats.getMax());
		System.out.println("Lowest prime number in List : " + stats.getMin());
		System.out.println("Sum of all prime numbers : " + stats.getSum());
		System.out.println("Average of all prime numbers : " + stats.getAverage());
	}
	public static void main(String[] args) {
		LamdaTest lamdaTest=new LamdaTest();
		lamdaTest.test1();
		//lamdaTest.test2();
		lamdaTest.test3();
		//System.out.println("---");
		lamdaTest.test4();
		lamdaTest.test5();

		lamdaTest.test6();
		lamdaTest.test7();
		lamdaTest.test8();
		lamdaTest.test9();
		lamdaTest.test10();
	}
}
