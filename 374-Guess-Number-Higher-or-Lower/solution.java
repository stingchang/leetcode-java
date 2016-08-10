/* The guess API is defined in the parent class GuessGame.
   @param num, your guess
   @return -1 if my number is lower, 1 if my number is higher, otherwise return 0
      int guess(int num); */

public class Solution extends GuessGame {
    public int guessNumber(int n) {
        return ans(1, n);
    }
    public int ans(int a, int b){
        int mid = a+(a+b)/2;
        int result = guess(mid);
        if(result == 0)
            return mid;
        if(result < 0)
            return ans(a, mid-1);
        else    
            return ans(mid+1, b);
    }
}