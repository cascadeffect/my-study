package com.kh.control;

import java.util.Scanner;

public class Break1Exam {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.print("문자열을 입력하세요>> ");
			String input = sc.nextLine();
			if(input.equals("end")) // if(input == "end") (X)
				break;
			System.out.println("문자열의 길이: " + input.length());
		}
		
		for(;;) {
			
		}
	}

}
