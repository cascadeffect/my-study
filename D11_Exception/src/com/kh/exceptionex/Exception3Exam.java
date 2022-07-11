package com.kh.exceptionex;

public class Exception3Exam {

	public static void main(String[] args) {
		// NumberFormatException - 형변환 예외
		String iNumStr = "3";
		int iNum = 0;
		iNum = Integer.parseInt(iNumStr);

		String dNumStr = "3.14";
		double dNum = Double.parseDouble(dNumStr);

//		iNum = Integer.parseInt(dNumStr); // NumberFormatException

		String[] strNums = { "23", "12", "", "98" };
		int i = 0;
		try {
			for (i = 0; i < strNums.length; i++) {
				int num = Integer.parseInt(strNums[i]);
				System.out.println("숫자로 변환된 값: " + num);
			}
		} catch (NumberFormatException e) {
			System.out.println(strNums[i] + "는 정수로 변환할 수 없습니다.");
		}
	}
}
