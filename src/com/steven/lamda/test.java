package com.steven.lamda;

public class test {
	//2ԪǮһƿ  4��ƿ�ǻ�һƿ 2����ƿ��һƿ 10��Ǯ���Զ���ƿ
	public static void main(String[] args) {
		int money=10; //Ǯ������
		int n=0; //ƿ��
		int k=0; //��ƿ
		int j=0; //��¼���Ի���ƿ��
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
