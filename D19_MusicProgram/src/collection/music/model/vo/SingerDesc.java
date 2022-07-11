package collection.music.model.vo;

import java.util.Comparator;

public class SingerDesc implements Comparator{

	@Override
	public int compare(Object o1, Object o2) {
		Music m1 = (Music)o1;
		Music m2 = (Music)o2;
		return m1.getSinger().compareTo(m2.getSinger()) * -1;
	}

}
