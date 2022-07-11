package com.kh.javaapi;

public class Exam_WrapperClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int num = 3;

		Integer input = new Integer(3);
		Integer nInput = 100; // 100->new Integer(100) ; Auto Boxing
		int iNum = input; // Auto-UnBoxing

		Long lnum = new Long(22222);

		Integer value = Integer.valueOf(33);
		Long lValue = Long.valueOf("2222");

		String strNum = "220613";
		String strNum2 = "221118";
		int result = Integer.parseInt(strNum2) - Integer.parseInt(strNum);
		System.out.println("결과 : " + result);

		String strNum3 = "3.14";
		double result2 = Double.parseDouble(strNum3);
		System.out.println("결과 : " + result2);

		// parse____ : String을 _____ type으로 바꿈
		byte bValue = Byte.parseByte("1");
		short sValue = Short.parseShort("2");
		int iValue = Integer.parseInt("3");
		long lInput = Long.parseLong("4");

		float fValue = Float.parseFloat("0.1");
		double dValue = Double.parseDouble("0.2");

		boolean bInput = Boolean.parseBoolean("true");

		char CValue = "JAVA".charAt(0);

	}

	static void parsingStringExample() {  // String으로 만들어주기
		
		// 3 - > String
		
		Integer.valueOf(3).toString();
		Long.valueOf(1).toString();
		
		String bStr=Byte.valueOf((byte)1).toString();
		String sStr=Short.valueOf((short)2).toString();
		String iStr=Integer.valueOf(3).toString();
		String lStr=Long.valueOf(4l).toString();
		
		String fStr=Float.valueOf(0.3f).toString();
		String dStr=Double.valueOf(0.2).toString();

		String boolStr = Boolean.valueOf(true).toString();
		String cStr = Character.valueOf('A').toString();

		String data=String.valueOf(123);
		String input=1234+"";
	}

}
