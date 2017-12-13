package nl.hsleiden.iad1.bigo;

public class BigO {

	static Pedometer pd = new Pedometer(); 
	
	// example of O(1)
	public void constant(int n){
		for (int i = 0; i < 20; i++) {
			pd.stepped();
		}
	}
	
	// example of O(N)
	public void linear(int n){
		for (int i = 0; i < n; i++) {
			pd.stepped();
		}
	}
	
	// example of O(N) with recursion
	public void linearRecursive(int n){
		if(n > 0){
			pd.stepped();
			linearRecursive(n-1);
		}	
	}
	
	
	// example of O(N^2)
	public void quadratic(int n){
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				pd.stepped();
			}
		}
	}

	// another example of O(N^2)
	public void quadratic2(int n){
		for(int i= 0; i < n/2; i++){
			for(int j= 0; j < n; j++){
				pd.stepped();
			}

		}
	}
	
	// example of O(N^3)
	public void cubic(int n){
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				for (int k = 0; k < n; k++) {
					pd.stepped();
				}
			}
		}
	}
	
	// example of O(log N)
	public void logarithmic(int n){
		for (int i = n; i > 1; i = i/2) {
			pd.stepped();
		}
	}

	// another example of O(log N)
	public void logarithmic2(int n){
		int goal = n;
		for (int i = 0; i < goal; i++) {
			pd.stepped();
			goal = goal/2;
		}
	}
	
	// example of O(2^N) with recursion
	public void exponentialRecursive(int n){
		if(n > 0){
			pd.stepped();
			exponentialRecursive(n-1);
			exponentialRecursive(n-1);
		}	
	}
	
	
	public static void main(String[] args){		
		int[] ns = {10,20,40,80};
		for(int n: ns){
			pd = new Pedometer();
			new BigO().logarithmic2(n);
			pd.printNumberOfSteps();
		}
		System.out.println("-----------------");
		for(int n: ns){
			pd = new Pedometer();
			new BigO().constant(n);
			pd.printNumberOfSteps();
		}

	}
}
