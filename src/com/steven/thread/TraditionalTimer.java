package com.steven.thread;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;


public class TraditionalTimer {

	public static void main(String[] args) {

		//简单定时器的demo
		new Timer().schedule(new TimerTask() {          
			@Override
			public void run() {
				//实际中会扔一个对象进来，我们就可以在这里操作这个对象的所有方法了
				System.out.println("--boom--");//爆炸
			}
		}, new Date(),3000); 
		//打印秒钟，一秒输出一次,用来方便观察的
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
