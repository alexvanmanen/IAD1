package nl.hsleiden.iad1.bigo;

/*
 * an instrument for recording the number of steps taken.
 */
public class Pedometer {

	private int steps;

	public void stepped() {
		steps++;
	}

	public void printNumberOfSteps() {
		System.out.println(steps);
	}

}
