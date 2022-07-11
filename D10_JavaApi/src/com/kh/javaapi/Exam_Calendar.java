package com.kh.javaapi;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.print.CancelablePrintJob;

public class Exam_Calendar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Date date = new Date();
		System.out.println(date);

		SimpleDateFormat trans = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		String strDate = trans.format(date);
		System.out.println(strDate);

		Calendar today = Calendar.getInstance();
		// Calendar 추상클래스 -> 나라마다 달력 다르게 표기하기 때문에

		int year = today.get(Calendar.YEAR);
		int month = today.get(Calendar.MONTH);
		int day = today.get(Calendar.DATE);
		int ampm = today.get(Calendar.AM_PM);
		int hour = today.get(Calendar.HOUR_OF_DAY);
		int min = today.get(Calendar.MINUTE);
		int sec = today.get(Calendar.SECOND);

		// 오전 오후 표시
		String sAmPm = (ampm == Calendar.AM) ? "AM" : "PM";

		System.out.printf("%d, %d, %d \n%s, %d:%d:%d", year, month, day, sAmPm, hour, min, sec);

		System.out.println();

		// Date 클래스는보다
		// GregorianCalendar 사용 권장
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(new Date());
		System.out.println(calendar.getTime());

		String changed = trans.format(calendar.getTime());
		System.out.println("changed : " + changed);
	}

}
