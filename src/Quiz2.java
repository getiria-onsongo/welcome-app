import java.util.List;
import java.util.LinkedList;
import edu.macalester.graphics.*;

class Quiz2 {

    GraphicsGroup removedPoints = new GraphicsGroup();
    Quiz2(){

    }
	// ----------------------------------------- BIG 0

	public String alphabet(char c, String inputStr) { 
        int n = inputStr.length();
		int steps = 0;
        for (int i=0; i < n; i++){
            if(inputStr.charAt(i) == c){
                return inputStr;
            }
			steps = steps + 1;
        }
        inputStr = inputStr + c;
		System.out.println("Steps for String of size  ="+inputStr.length()+" is "+steps+" steps");
        return inputStr;
    }

    // Count steps
    public void sortArray(int[] input) {
		int steps = 0;
		boolean hasSwapped = true;
		while (hasSwapped) {
	    	hasSwapped = false;
	    	for (int sort = 0; sort < input.length - 1; sort++) {
				if (input[sort] > input[sort + 1]) {
		    		int oldValue = input[sort + 1];
		    		input[sort + 1] = input[sort];
		    		input[sort] = oldValue;
		    		hasSwapped = true;
				}
				steps = steps + 1;
			}
		}
		System.out.println("Steps for sortArray.length ="+input.length+" is "+steps+" steps");
    }
    
    // Test a solution that is O(N)
    public void testQ1c_solutin1(int n){
	int acc = 0;
        for(int i=1; n > i; i++){
            acc = acc + (n - i);
        }
        System.out.println("Steps for "+n+" handshakes="+acc);
    }

	// ----------------------------------------- LISTS
    // Test section

    // 
    public void simplifyShape(List<Point> boundary, int n) {
        // While we have more points than n, keep going. 
        while(boundary.size() > n) {
            double leastImpScore = Double.MAX_VALUE;
            double leastImpIndex = -1;
            // Loop through the points
            for(int P=0; P < boundary.size(); P++){
                int L = P-1;
                if (L < 0) {
                    // If this is the first point, wrap around
                    L = boundary.size()-1;
                }
                int R = P+1;
                if (R >= boundary.size()) {
                    // If this is the last point, wrap around
                    R = 0;
                }
                // Compute importance 
                double l1 = boundary.get(L).distance(boundary.get(P));
                double l2 = boundary.get(P).distance(boundary.get(R));
                double l3 = boundary.get(L).distance(boundary.get(R));
                double importance = l1 + l2 - l3;
                if (importance < leastImpScore) {
                    // Update least important point
                    leastImpScore = importance;
                    leastImpIndex = P;
                }
            }
            // Remove least important point
            boundary.remove((int) leastImpIndex);
        }
    }
    
    public static void main(String[] args) {

	Quiz2 q2 = new Quiz2();

	// ----------------------------------------- BIG 0
	/* 
	// Test alphabet
	String alphabet = "123456789a";
	alphabet = q2.alphabet('a', alphabet);
    System.out.println("alphabet="+alphabet);

	// Test interesting student solution
	q2.testQ1c_solutin1(5);

	// Test sortArray
	int[] intArr = new int[] {10,9,8,7,6,5,5,3,2,1};
	q2.sortArray(intArr);

    */
    // ----------------------------------------- LISTS
    List<Point> square = new LinkedList<Point>();
    square.add(new Point(0,0));
    square.add(new Point(0,2));
    square.add(new Point(1,2));
    square.add(new Point(2,0));
    square.add(new Point(2,2));
    
    System.out.println("\nPoints before simplify");
    System.out.println(square);

    System.out.println("\nPoints after simplify");
    q2.simplifyShape(square, 4);
    System.out.println(square);
	
    }
}
