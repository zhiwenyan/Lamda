package com.steven.thread;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;


public class TraditionalTimer {

	public static void main(String[] args) {

		//�򵥶�ʱ����demo
		new Timer().schedule(new TimerTask() {          
			@Override
			public void run() {
				//ʵ���л���һ��������������ǾͿ�����������������������з�����
				System.out.println("--boom--");//��ը
			}
		}, new Date(),3000); 
		//��ӡ���ӣ�һ�����һ��,��������۲��
		while(true) {
			SimpleDateFormat format=new SimpleDateFormat("HH:mm:ss");
			System.out.println(format.format(new Date()));
			try {
				Thread.sleep(1000);
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
}
