package com.xiehui.util;


import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JLabel;

public class MyThread extends Thread{
	private JLabel jl;
	
	public MyThread(JLabel jl){
		this.jl=jl;
	}

	public void run(){
		
		while(true){
			//Date
			Date date=new Date();
//			System.out.println(date);
			//格式调整
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String sdate=sdf.format(date);
//			System.out.println(sdate);
			jl.setText(sdate);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
}
