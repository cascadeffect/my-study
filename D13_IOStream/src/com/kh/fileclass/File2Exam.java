package com.kh.fileclass;

import java.io.File;

public class File2Exam {

	public static void main(String[] args) {
		// ���� ���� �˾ƿ���
		File fileInfo = new File("inputStream.txt");
		File projectInfo = new File("");
		File srcInfo = new File("src\\com\\kh\\fileclass\\File2Exam.java");

		System.out.println("���ϸ�: " + fileInfo.getName());
		System.out.println("���� �뷮: " + fileInfo.length());
		System.out.println("���� ����: " + fileInfo.getParent());
		System.out.println("���� ��� ���: " + fileInfo.getPath());
		System.out.println("���� ���� ���: " + fileInfo.getAbsolutePath());
		
		System.out.println("������Ʈ ���� ���: " + projectInfo.getAbsolutePath());
		
		System.out.println("�ҽ��ڵ� ���� ���: " + srcInfo.getAbsolutePath());
	}

}
