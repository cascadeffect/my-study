package collection.music.model.vo;

import java.util.Comparator;

public class TitleDesc implements Comparator {

	@Override
	public int compare(Object o1, Object o2) {
		Music m1 = (Music)o1;
		Music m2 = (Music)o2;
		return m1.getTitle().compareTo(m2.getTitle()) * -1;
	}

}
