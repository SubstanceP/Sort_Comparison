package sortcomparison;

import static sbcc.Core.*;

import java.util.*;

public class BasicSorter implements Sorter {
	// String temp0 = data.get(i - 1);
	// int j = i;
	// int i =
	// collections.swap
	// array.copy
	ArrayList<String> mergeArray = new ArrayList<String>();


	@Override
	public void insertionSort(ArrayList<String> data, int firstIndex, int numberToSort) {
		for (int i = firstIndex + 1; i < firstIndex + numberToSort; i++) {
			String temp = data.get(i);
			int j = i;
			while (j > firstIndex && temp.compareTo(data.get(j - 1)) < 0) {
				// println("yo");
				Collections.swap(data, j, j - 1);
				j--;
			}
		}
	}


	@Override
	public void quickSort(ArrayList<String> data, int firstIndex, int numberToSort) {

		if (numberToSort < 16) {
			insertionSort(data, firstIndex, numberToSort);
		}
		if (numberToSort > 1) {
			// medianThree
			// medianThree()
			String med = findMedian(data.get(firstIndex), data.get(numberToSort / 2 + firstIndex),
					data.get(numberToSort + firstIndex - 1));
			int median;
			if (med.equals(data.get(firstIndex))) {
				median = firstIndex;
			} else if (med.equals(data.get(numberToSort / 2 + firstIndex))) {
				median = numberToSort / 2 + firstIndex;
			} else {
				median = numberToSort + firstIndex - 1;
			}
			Collections.swap(data, firstIndex, median);

			int pivotNdx = partition(data, firstIndex, numberToSort);

			// int pivotNdx = 0;
			/*
			 * if (numberToSort % 2 == 0) { pivotNdx = numberToSort / 2 - 1; } else {
			 * pivotNdx = (numberToSort - 1) / 2; }
			 */
			quickSort(data, firstIndex, pivotNdx - firstIndex);
			quickSort(data, pivotNdx + 1, numberToSort - (pivotNdx - firstIndex + 1));

			// int pivotPt = numberToSort/2 -1;

		}

	}


	public String findMedian(String first, String mid, String last) {
		if (mid.compareTo(first) > 0 && first.compareTo(last) > 0
				|| last.compareTo(first) > 0 && first.compareTo(mid) > 0) {
			return first;
		} else if (first.compareTo(mid) > 0 && mid.compareTo(last) > 0
				|| last.compareTo(mid) > 0 && mid.compareTo(first) > 0) {
			return mid;
		} else {
			return last;
		}
	}
	/*
	 * } else if (first.compareTo(last) > 0 && last.compareTo(mid) > 0 ||
	 * mid.compareTo(last) > 0 && last.compareTo(first) > 0) { return last;
	 */
	// findMedian(data.get(firstIndex), data.get(tooSmallNdx / 2),
	// data.get(tooSmallNdx));


	@Override
	public int partition(ArrayList<String> data, int firstIndex, int numberToPartition) {
		// TODO Auto-generated method stub
		// local variables to strack the pivot and indecies relative to the pivot
		int tooBigNdx = firstIndex + 1;
		int tooSmallNdx = firstIndex + numberToPartition - 1;
		String pivot = data.get(firstIndex);
		// base case
		while (tooBigNdx < tooSmallNdx) {
			while (tooBigNdx < tooSmallNdx && data.get(tooBigNdx).compareTo(pivot) <= 0) {
				tooBigNdx++;
			}
			while (tooSmallNdx > firstIndex && data.get(tooSmallNdx).compareTo(pivot) > 0) {
				tooSmallNdx--;
			}
			if (tooBigNdx < tooSmallNdx) {
				// String temp = data.get(tooBigNdx);
				// data.get(tooBigNdx) = data.get(tooSmallNdx);
				Collections.swap(data, tooBigNdx, tooSmallNdx);
			}
		}
		if (pivot.compareTo(data.get(tooSmallNdx)) >= 0) {
			Collections.swap(data, firstIndex, tooSmallNdx);
			return tooSmallNdx;
		} else {
			return firstIndex;
		}

	}


	@Override
	public void mergeSort(ArrayList<String> data, int firstIndex, int numberToSort) {
		// TODO Auto-generated method stub
		// mergeArray.clear();
		int left = 0;
		int right = 0;

		if (numberToSort <= 1) {
			return;
		}

		if (numberToSort == 16) {
			insertionSort(data, firstIndex, numberToSort);
		} else {
			left = numberToSort / 2;
			right = numberToSort - left;

			mergeSort(data, firstIndex, left);
			mergeSort(data, firstIndex + left, right);

			if (data.get(firstIndex + left - 1).compareTo(data.get(firstIndex + left)) >= 0) {
				merge(data, firstIndex, left, right);
				mergeArray.clear();
			}
		}

	}


	@Override
	public void merge(ArrayList<String> data, int firstIndex, int leftSegmentSize, int rightSegmentSize) {

		int leftNdx = 0;
		int rightNdx = leftSegmentSize;
		// leftSegmentSize += firstIndex;
		// rightSegmentSize += firstIndex;

		while (leftNdx < leftSegmentSize && rightNdx < rightSegmentSize + leftSegmentSize) {
			if (data.get(leftNdx + firstIndex).compareTo(data.get(rightNdx + firstIndex)) <= 0) {
				mergeArray.add(data.get(leftNdx + firstIndex));
				leftNdx++;
			} else {
				mergeArray.add(data.get(rightNdx + firstIndex));
				rightNdx++;
			}
		}
		while (leftNdx < leftSegmentSize) {
			mergeArray.add(data.get(leftNdx + firstIndex));
			leftNdx++;
		}
		while (rightNdx < rightSegmentSize) {
			mergeArray.add(data.get(rightNdx + firstIndex));
			rightNdx++;
		}

		for (int i = 0; i < mergeArray.size(); i++) {
			data.set(i + firstIndex, mergeArray.get(i));
		}

	}


	@Override
	public void heapSort(ArrayList<String> data) {
		// TODO Auto-generated method stub

	}


	@Override
	public void heapify(ArrayList<String> data) {
		// TODO Auto-generated method stub

	}

}
