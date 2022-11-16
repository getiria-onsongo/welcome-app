import java.util.List;
import java.util.LinkedList;

public class Test {
    
    public Test() {
        
    }

    public long fibonacci_dp(int n){
        long [] dp = new long[n+1];
        for(int i=0; i < n+1; i++){
            if(i < 2){
                dp[i] = i;
            }else{
                dp[i] = dp[i-1] + dp[i-2];
            }
            //System.out.println(dp[i]);
        }
        return dp[n];
    }

    public long fibonacci_rec(int n){
        if(n == 0){
            return 0;
        }else if(n == 1){
            return 1;
        }else{
            return fibonacci_rec(n-1) + fibonacci_rec(n-2);
        }
    }

    public static void main(String[] args) {

        System.out.println("Sandbox");
        /* 
        
        SimpleTranslator t = new SimpleTranslator();

        t.addTranslation("gr8","great");
        t.addTranslation("irl","in real life");
        t.addTranslation("r","are");
        t.addTranslation("comp128","data structures");

        System.out.println("\nTest 1");
        List<String> phrase = new LinkedList<String>();
        phrase.add("irl");
        phrase.add("hashtables");
        phrase.add("r");
        phrase.add("gr8");
        t.translateWords(phrase);

        System.out.println("\nTest 2");
        List<String> phrase1 = new LinkedList<String>();
        phrase1.add("comp128");
        phrase1.add("is");
        phrase1.add("a");
        phrase1.add("gr8");
        phrase1.add("course");
        t.translateWords(phrase1);
        */
        Test t = new Test();
        int n = 47;
        System.out.println("fibonacci_dp("+n+")="+t.fibonacci_dp(n));
        System.out.println("fibonacci_rec("+n+")="+t.fibonacci_rec(n));

    }
}
