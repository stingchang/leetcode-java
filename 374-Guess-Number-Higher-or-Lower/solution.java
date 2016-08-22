/* The guess API is defined in the parent class GuessGame.
   @param num, your guess
   @return -1 if my number is lower, 1 if my number is higher, otherwise return 0
      int guess(int num); */

public class Solution extends GuessGame {
    public int guessNumber(int n) {
        int a = 1, b = n;
        int g = a+(b-a)/2;
        while(guess(g)!=0){
            if(guess(g)>0)
                a = g+1;
            else 
                b = g-1;
            g = a+(b-a)/2;    
        }
        return g;
    }
}