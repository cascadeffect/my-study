package collection.music.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import collection.music.model.vo.Music;
import collection.music.model.vo.SingerAsc;
import collection.music.model.vo.SingerDesc;
import collection.music.model.vo.TitleDesc;

public class MusicController {
	private List<Music> musicList;

	public MusicController() {
		musicList = new ArrayList<Music>();
	}

	// 마지막 위치에 곡 추가
	public void addAtLast(Music music) {
		musicList.add(music);
	}

	// 첫 위치에 곡 추가
	public void addAtFirst(Music music) {
		musicList.add(0, music);
	}

	// 전체 곡 목록 출력
	public List<Music> showAllMusic() {
		return musicList;
	}

	// 특정 곡명 검색 => 인덱스 리턴
	public int searchMusicByTitle(String title) {
		for (int i = 0; i < musicList.size(); i++) {
			Music musicOne = musicList.get(i);
			if (title.equalsIgnoreCase(musicOne.getTitle()))
				return i;
		}
		return -1;
	}

	// 곡명으로 중복 검색
	public List<Music> searchMusicByName(String title) {
		List<Music> searchList = new ArrayList<Music>();
		for (int i = 0; i < musicList.size(); i++) {
			Music music = musicList.get(i);
			if (title.equals(music.getTitle()))
				searchList.add(musicList.get(i));
		}
		return searchList;
	}

	// 인덱스를 통해 곡 찾기 => 곡 객체 리
	public Object findMusicByIndex(int index) {
		return musicList.get(index);
	}

	// 특정 곡 정보 수정
	public void modifyMusicInfo(int index, Music modifiedMusic) {
		if (modifiedMusic.getTitle() != null) {
			musicList.get(index).setTitle(modifiedMusic.getTitle());
		}
		if (modifiedMusic.getSinger() != null) {
			musicList.get(index).setSinger(modifiedMusic.getSinger());
		}
//		musicList.set(index, music);
	}

	// 특정 곡 삭제
	public void deleteMusic(int index) {
		musicList.remove(index);
	}

	// 곡명 오름차순 정렬
	public void sortByTitleAsc() {
		Collections.sort(musicList);
	}

	// 곡명 내림차순 정렬
	public void sortByTitleDesc() {
		Collections.sort(musicList, new TitleDesc());
	}

	// 가수명 오름차순 정렬
	public void sortBySingerAsc() {
		Collections.sort(musicList, new SingerAsc());
	}

	// 가수명 내림차순 정렬
	public void sortBySingerDesc() {
		Collections.sort(musicList, new SingerDesc());
	}

}
