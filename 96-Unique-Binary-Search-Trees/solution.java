public class Solution {
    public int numTrees(int n) {
        /*
        f(0) = 1;
        f(1) = 1;
        f(2) = (f(1)*f(0)) + (f(0)*f(1)) = 2;
        f(3) = (f(2)*f(0)) + (f(1)*f(1)) + (f(0)*f(2)) = 5;
        f(4) = (f(3)*f(0)) + (f(2)*f(1)) + (f(1)*f(2)) + (f(0)*f(3)) = 14;
        f(n) = (f(n-1)*f(0)) + (f(n-2)*f(1)) +...+ (f(1)*f(n-2)) + (f(0)*f(n-1)) ;
        */
        if(n<=0)
            return 0;
            
        if(n==1)
            return 1;
        
        int[] t = new int[n+1];
        t[0] = 1;
        t[1] = 1;
        for(int i =2; i<= n; i++){
            
            int sum = 0;
            for(int j = 0; j<i; j++){
                sum += t[j] * t[i-j-1];
            }
            t[i] = sum;
        }
        return t[n];
    }
}