package nl.alexvanmanen.iad1.algorithms.sorting.quicksort;

public class QuickSortWithWall {

	public void sort(int[] array) {
		sort(array, 0, array.length - 1);
	}

	private void sort(int[] array, int positionLeft, int positionRight) {
		if (positionLeft >= positionRight)
			return;

		int pivotPosition = positionRight;
		int pivotValue = array[positionRight];
		int wall = positionLeft;

		for (int currentPosition = positionLeft; currentPosition < positionRight; currentPosition++) {
			if (pivotValue > array[currentPosition]) {
				swap(array, currentPosition, wall);
				wall++;
			}
		}

		swap(array, pivotPosition, wall);
		sort(array, positionLeft, wall - 1);
		sort(array, wall, positionRight);
	}

	private void swap(int[] array, int positionA, int positionB) {
		int temp = array[positionA];
		array[positionA] = array[positionB];
		array[positionB] = temp;
	}
}
