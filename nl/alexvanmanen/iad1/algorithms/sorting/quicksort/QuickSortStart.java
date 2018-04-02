package nl.alexvanmanen.iad1.algorithms.sorting.quicksort;
import java.util.Arrays;

/**
 * @author Alex van Manen
 * @since December 14, 2013
 */
public class QuickSortStart {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		QuickSort quickSort = new QuickSort();
		int[] array = { 5, 7, 9, 8, 10, 6, 4, 3, 2, 1 };
		System.out.println(Arrays.toString(array));
		quickSort.quickSort(array);
		System.out.println("Sorting is done");
		System.out.println(Arrays.toString(array));
	}
}
