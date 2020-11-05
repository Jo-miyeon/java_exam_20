package java_exam;

import java.util.ArrayList;

interface ComparatorInterface {
	int compare(Article a1, Article a2);
}

class comparator2 implements ComparatorInterface {
	private ArrayList<Article> articles;

	public comparator2() {
		articles = new ArrayList<>();
	}

	String sort_method = "asc";

	@Override
	public int compare(Article a1, Article a2) {
		if (sort_method.equals("asc")) {
			if (a1.getId() < a2.getId()) {
				return 1;
			}
		} else {
			if (a1.getId() < a2.getId()) {
				return 1;
			}
		}
		return -1;
	}
}
