package com.kh.javaapi;

public class Exam_String {
	
	public static void main(String[] args) {
		String data1=new String(" C#");
		String data2=new String(", C++ ");
		
		System.out.println("#이 있는가? : "+data1.contains("#"));
		
		data1=data1.concat(data2);
		System.out.println("연결된 문자열 : "+data1);
		
		//공백 제거
		data1=data1.trim();
		System.out.println("공백 제거 확인 : "+data1);
		
		// C# -> JAVA
		data1=data1.replace("C#", "JAVA");
		System.out.println("문자열 교체 : "+data1);
		
		// 문자열 분리
		String[] words=data1.split(",");
		for(int i=0; i<words.length;i++) {
			System.out.println("분리된 문자열 : "+words[i]);
		}
		
		// 문자열 자르기
		data1=data1.substring(0,4);
		System.out.println("범위로 자르기 : "+data1);
		
		
		char word=data1.charAt(0);
		
	}
	
	

}
