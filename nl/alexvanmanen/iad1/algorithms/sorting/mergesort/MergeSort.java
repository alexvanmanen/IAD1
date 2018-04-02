package nl.alexvanmanen.iad1.algorithms.sorting.mergesort;

public class MergeSort {

	int[] array;
	int[] tempArray;

	public void sort(int[] array) {
		this.array = array;
		tempArray = new int[array.length];
		mergesort(0, array.length - 1);
	}

	public void mergesort(int lowestPosition, int highestPostion) {
		if (lowestPosition >= highestPostion) return;
		
		int middlePosition = (lowestPosition + highestPostion) / 2;
		mergesort(lowestPosition, middlePosition);
		mergesort(middlePosition + 1, highestPostion);
		merge(lowestPosition, middlePosition, highestPostion);
	}

	public void merge(int pointerLeft, int limitLeft, int limitRight) {
		copyValuesFromArrayToTempArray();
		int pointerRight = limitLeft + 1;
		
		for (int i = pointerLeft; i <= limitRight; i++) {
			boolean elementsRightSideProcessed = pointerRight > limitRight;
			boolean elementsLeftSideProcessed = pointerLeft > limitLeft;
			
			if (elementsRightSideProcessed || (!elementsLeftSideProcessed && leftValueIsSmallerThanRightValue(pointerLeft, pointerRight))){
				copyValueFromTempArrayToArray(pointerLeft, i);
				pointerLeft++;
			}	else  {
				copyValueFromTempArrayToArray(pointerRight, i);
				pointerRight++;
			}
		}
	}

	private boolean leftValueIsSmallerThanRightValue(int pointerLeft, int pointerRight) {
		return tempArray[pointerLeft] < tempArray[pointerRight];
	}

	private void copyValueFromTempArrayToArray(int pointerRechts, int i) {
		array[i] = tempArray[pointerRechts];
	}

	private void copyValuesFromArrayToTempArray() {
		for (int i = 0; i < array.length; i++) {
			tempArray[i] = array[i];
		}
	}

	public static void main(String[] args) {
		int[] list = { 8, 7, 9, 2 };
		new MergeSort().sort(list);
		for (int i = 0; i < list.length; i++) {
			System.out.println(list[i]);
		}

	}
}
