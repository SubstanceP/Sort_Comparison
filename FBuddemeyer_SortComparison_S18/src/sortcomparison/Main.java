package sortcomparison;

import static sbcc.Core.*;

import java.util.*;

import static java.lang.System.*;
import static org.apache.commons.lang3.StringUtils.*;

public class Main {

	public static void main(String[] args) {

		ArrayList<String> test = new ArrayList<String>();
		BasicSorter b = new BasicSorter();
		test.add("james");
		test.add("bill");
		test.add("zack");
		test.add("kyle");
		test.add("pete");
		test.add("jaun");
		test.add("john");
		test.add("harrison");
		test.add("rachel");
		test.add("grace");
		// b.insertionSort(test, 0, test.size());
		// b.merge(test, 0, 5, 5);
		b.mergeSort(test, 0, 10);
		for (String s : test)
			println(s);

	}

}
