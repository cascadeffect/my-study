package com.kh.javaapi;

public class Exam_StringBuffer {
	
	public static void main(String[] args) {
		StringBuffer sb=new StringBuffer();
		
		sb.append("Hello");
		sb.append(" ");
		sb.append("Java");
		
		System.out.println("연결된 문자열 : "+sb.toString());
		String result="Hello"+" "+"Java";
		System.out.println("+로 연결된 문자열 : "+result);
		
		StringBuffer stb=new StringBuffer().append("KH").append(" Java Clss").append(" Good");
		System.out.println("연결된 문자열 : "+stb.toString());
		stb.delete(14, 18);
		System.out.println(stb.toString());
		
	}

}
