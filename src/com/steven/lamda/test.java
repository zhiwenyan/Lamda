package com.steven.lamda;

public class test {
	//2元钱一瓶  4个瓶盖换一瓶 2个空瓶换一瓶 10块钱可以多少瓶
	public static void main(String[] args) {
		int money=10; //钱的总数
		int n=0; //瓶盖
		int k=0; //空瓶
		int j=0; //记录可以换的瓶数
		while(money>0){
			money=money-2;
			j++;
			k++;
			n++;
			System.out.print(j+",");			
			if (n==4) {
				money=money+2;
				n=0;
			}
			if(k==2){
				money=money+2;
				k=0;
			}
		}
	}
}
