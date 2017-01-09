package org.joda.test.time;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;


/**
 * 测试Calendar
 * @author fenfe
 *
 */
public class TimeTest {
	
	private static SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	public static void main(String[] args) {
		//testRoll();
		//testAdd();
		//testSet();
		//testGregorian();
		testDirrTime();
	}
	
	
	/**
	 * 测试roll()方法
	 * DAY_OF_YEAR 以Day为单位，在year范围内滚动
	 * DAY_OF_MONTH 以Day为单位，在Month范围内滚动
	 * DAY_OF_WEEK_IN_MONTH 以星期为单位灶在Month范围内滚动
	 */
	public static void testRoll(){
		Calendar can=Calendar.getInstance();
		//can.set(Calendar.DAY_OF_YEAR, 2);
		System.out.println(sdf.format(can.getTime()));
		for(int i=0;i<45;i++){
			can.roll(Calendar.HOUR_OF_DAY, 1);
			printDate(can);
		}
	}
	
	
	/*
	 * HOUR_OF_DAY 以hour为单位增加 没有范围概念
	 */
	public static void testAdd(){
		Calendar can=Calendar.getInstance();
		//日期往后两天
		//can.add(Calendar.DATE, 2);
		can.add(Calendar.HOUR_OF_DAY, 430);
		printDate(can);
	}
	
	
	
	/**
	 * 测试set
	 */
	public static void testSet(){
		Calendar can=Calendar.getInstance();
		//can.clear();
		//printDate(can);
		//System.out.println(can.getTime().getTime());
		can.set(Calendar.YEAR, 0, Calendar.MONTH, 0, Calendar.DATE, 0);
		can.set(Calendar.HOUR, 0,Calendar.MINUTE,0,Calendar.SECOND,0);
		System.out.println(can.getTime().getTime());
		//printDate(can);
	}
	
	
	
	/**
	 * 自定义一个时间
	 */
	public static void testGregorian(){
		Calendar can = new GregorianCalendar(2017,1,1,12,20,22);
		printDate(can);
	}
	
	
	/**
	 * 测试时间差
	 */
	public static void testDirrTime(){
		Calendar start =Calendar.getInstance();
		Calendar end = new GregorianCalendar(2017,2,23,9,20,22);
		for(int i=0;i<5;i++){
			System.out.println(end.getTimeInMillis()-start.getTimeInMillis());
			System.out.println(end.getTime().getTime()-start.getTime().getTime());
			long sec=end.getTime().getTime()-start.getTime().getTime();
			long day=sec/(24*3600*1000);
			System.out.println(day+"天");
			try {
				Thread.sleep(260);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("*****");
		}
		
	}
	
	
	private static void printDate(Calendar can){
		System.out.println(sdf.format(can.getTime()));
	}

}
