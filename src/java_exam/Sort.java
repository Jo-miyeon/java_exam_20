package java_exam;

import java.util.ArrayList;
import java.util.List;

public class Sort {
	private ArrayList<Article> articles;

	public Sort() {
		articles = new ArrayList<>();
	}

	void sortor(List<Article> arr, comparator2 com) {
		for (int i = 0; i < arr.size() - 1; i++) {
			for (int j = 0; j < arr.size() - 1; j++) {
				if (com.compare(arr.get(j), arr.get(j + 1)) > 0) {
					Article tmp = arr.get(j);
					arr.set(j, arr.get(j + 1));
					arr.set(j + 1, tmp);
				}
			}
		}
	}
}

