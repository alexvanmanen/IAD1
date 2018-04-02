package nl.alexvanmanen.iad1.algorithms.sorting.quicksort;

/**
 * @author Alex van Manen
 * @since December 14, 2013
 */

public class QuickSort {

	public void quickSort(int[] array) {
		quickSort(array, 0, array.length - 1);
	}

	public void quickSort(int[] array, int l, int r) {
		/*
		 * pivot location is the location of the pivot in the array. Valid
		 * pivots are e.g. l, r or ((l+r)/2) (that's the one in the middle)
		 */
		int pivotLocation = l;
		int pivotValue = array[pivotLocation];

		int originalLeft = l;
		int originalRight = r;

		while (l < r) {
			while (array[r] > pivotValue) {
				r--;
			}
			while (array[l] < pivotValue) {
				l++;
			}
			if (l <= r) {
				/*
				 * Left value is moved to the right and the right value to the
				 * left.
				 */
				int valueLeft = array[l];
				array[l] = array[r];
				array[r] = valueLeft;
				r--;
				l++;
			}
		}

		// Sorting the left side
		if (originalLeft < r) {
			quickSort(array, originalLeft, r);
		}

		// sorting the right side
		if (l < originalRight) {
			quickSort(array, l, originalRight);
		}
	}
}
