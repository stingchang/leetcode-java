public class Solution {
    public int hIndex(int[] citations) {
        Arrays.sort(citations, Collections.reverseOrder());
        //Arrays.sort(citations, Collections.reverseOrder());
        int max = 0;
        for(int i =0; i< citations.length; i++){
            if(i+1 <= citations[i])
                max = i+1;
            else 
                return max;
        }
        return 0;
    }
}