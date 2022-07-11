package com.kh.map;

import java.util.HashMap;
import java.util.Map;

import com.kh.domain.Student;

public class Run {

	public static void main(String[] args) {

		Map<String, String> map = new HashMap<String, String>();
		map.put("02", "서울");
		map.put("031", "경기도");
		map.put("032", "인천");

		System.out.println("02를 누르면 서울이 나옵니다.>> " + map.get("02"));
		System.out.println("031를 누르면 경기도가 나옵니다.>> " + map.get("031"));
		System.out.println("032를 누르면 인천이 나옵니다.>> " + map.get("032"));
		System.out.println("저장된 데이터의 수: " + map.size());

		Map<String, Object> objMap = new HashMap<String, Object>();
		objMap.put("name", "고네");
		objMap.put("score", 100);
		objMap.put("isReal", true);
		System.out.println(objMap.get("name") + "은 " + objMap.get("score") + "점입니다. " + objMap.get("isReal"));
		System.out.println();

		Map<Integer, Student> stdMap = new HashMap<Integer, Student>();
		stdMap.put(1, new Student("현", 100));
		stdMap.put(2, new Student("고네", 99));
		stdMap.put(3, new Student("봉식", 1));
		stdMap.put(4, new Student("상일", 20));

		// toString() 안 써도 됨
		System.out.println(stdMap.get(1));
		System.out.println(stdMap.get(2).toString());

		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.put("name", "현");
		dataMap.put("wife", new Student("고네", 100));

		selectList(dataMap);
	}

	static void selectList(Map<String, Object> objMap) {
		objMap.get("name");
		objMap.get("wife");
		System.out.println(objMap.get("name").toString() + ", " + objMap.get("wife").toString());
	}

}
