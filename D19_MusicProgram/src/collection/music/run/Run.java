package collection.music.run;

import java.util.InputMismatchException;
import java.util.List;

import collection.music.controller.MusicController;
import collection.music.model.vo.Music;
import collection.music.view.MusicView;

public class Run {

	public static void main(String[] args) {
		MusicView mView = new MusicView();
		MusicController mController = new MusicController();
		Music music = null;

		String title = null;
		int index = 0;

		EXIT: while (true) {
			try {
				int choice = mView.printMenu();
				switch (choice) {
				case 1: // 마지막 위치에 곡 추가
					music = mView.inputMusicInfo("마지막 위치");
					mController.addAtLast(music);
					mView.displaySuccess(music + " 추가 완료");
					break;
				case 2: // 첫 위치에 곡 추가
					music = mView.inputMusicInfo("첫 위치");
					mController.addAtFirst(music);
					mView.displaySuccess(music + " 추가 완료");
					break;
				case 3: // 전체 곡 목록 출력
					List musicList = mController.showAllMusic();
					mView.printMusicList(musicList, choice);
					break;
				case 4: // 특정 곡 검색
					title = mView.inputMusicName("검색");
					List searchList = mController.searchMusicByName(title);
					mView.printMusicList(searchList, choice);
					// 중복 곡명 모름
//					index = mController.searchMusicByTitle(title);
//					if (index == -1) {
//						mView.displayError("검색 결과 없음");
//						break;
//					}
//					music = mController.findMusicByIndex(index);
//					mView.printOneMusic(music);
					break;
				case 5: // 특정 곡 삭제
					title = mView.inputMusicName("삭제");
					index = mController.searchMusicByTitle(title);
					if (index == -1) {
						mView.displayError("검색 결과 없음");
						break;
					}
					music = (Music) mController.findMusicByIndex(index);
					mController.deleteMusic(index);
					mView.displaySuccess(music + " 삭제 완료");
					break;
				case 6: // 특정 곡 정보 수정
					title = mView.inputMusicName("수정");
					index = mController.searchMusicByTitle(title);
					if (index == -1) {
						mView.displayError("검색 결과 없음");
						break;
					}
					music = (Music) mController.findMusicByIndex(index);
					Music modifiedMusic = mView.modifyMusicInfo();
					mController.modifyMusicInfo(index, modifiedMusic);
					mView.displaySuccess(music + " 정보 수정 완료");
					break;
				case 7: // 곡명 오름차순 정렬
					mController.sortByTitleAsc();
					mView.displaySuccess("곡명 오름차순 정렬 완료");
					break;
				case 8: // 곡명 내림차순 정렬
					mController.sortByTitleDesc();
					mView.displaySuccess("곡명 내림차순 정렬 완료");
					break;
				case 9: // 가수명 오름차순 정렬
					mController.sortBySingerAsc();
					mView.displaySuccess("가수명 오름차순 정렬 완료");
					break;
				case 10: // 곡명 내림차순 정렬
					mController.sortBySingerDesc();
					mView.displaySuccess("가수명 내림차순 정렬 완료");
					break;
				case 0:
					break EXIT;
				default:
					mView.displayError("없는 메뉴 번호");
				}
			} catch (InputMismatchException e) {
				mView.displayError("잘못된 입력");
			}
		}
	}
}
