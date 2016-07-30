import java.util.Collections;
public class Solution {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        //Arrays.sort(citations, Collections.reverseOrder());
        //[6,5,3,1,0]
        //[1,2,3,4,5]
        int max = 5;
        for(int i =len-1; i>=0; i--){
            if(i+1<=citations[i])
                return i+1;
        }
        return 0;
    }
}