import java.util.Collections;
public class Solution {
    public int hIndex(int[] citations) {
        if(citations == null)
            return 0;
        int len = citations.length;    
        // create an array of citations, if citation larger than length, treat it as length
        int[] cites = new int[len+1];
        Arrays.fill(cites, 0);
        for(int i =0; i< len; i++){
            cites[Math.min(len, citations[i])] +=1;
        }
        
        for(int i =1; i< cites.length; i++){
            cites[i]+=cites[i-1];
        }
        System.out.printlnl(Arrays.toString(cites));
        
        for(int i =1; i< cites.length; i++){
            if(cites[i]<i)
                return i-1;
        }
        System.out.printlnl(Arrays.toString(cites));
        return 0;
        
    }
}