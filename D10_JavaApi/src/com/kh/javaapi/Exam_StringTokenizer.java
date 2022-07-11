package com.kh.javaapi;

import java.util.StringTokenizer;

public class Exam_StringTokenizer {
	public static void main(String[] args) {
		
		String str="AA,BB,CC";
		StringTokenizer strTk=new StringTokenizer(str,",");
		
		for (int i=0;strTk.hasMoreTokens();i++) {
			System.out.println(i + 1 + "¹øÂ° °ª : " + strTk.nextToken());
		}
	}
}
