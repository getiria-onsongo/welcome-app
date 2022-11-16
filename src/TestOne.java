public class TestOne {
    public TestOne(){

    }
    
    public long fibonacci_dp(int n_temp){
        int n = n_temp + 1;
        long[] dp = new long[n];
        for(int i=0; i < n; i++){
            if(i== 0){
                dp[i] = 0;
            }else if(i == 1){
                dp[i] = 1;
            }else{
                dp[i]= dp[i-1] + dp[i-2];
            }
        }
        return dp[n_temp];

    }

    public long fibonacci_rec(int n){
        
        if(n == 0){
            return 0;
        }else if(n ==1){
            return 1;
        }else{
            return fibonacci_rec(n-1) + fibonacci_rec(n-2);
        }

    }
    public static void main(String[] args) {
        TestOne t = new TestOne();

        int n =50;
        System.out.println("DP="+t.fibonacci_dp(n));
        System.out.println("REC="+t.fibonacci_rec(n));

}
}