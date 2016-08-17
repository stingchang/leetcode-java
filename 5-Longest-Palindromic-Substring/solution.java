public class Solution {
    public String longestPalindrome(String s) {
		// "", "s"
        if(s == null || s.length() <=1)
            return s;
        

        char[] arr = s.toCharArray();
        char[] c = new char[arr.length*2-1];
        for(int i =0; i< arr.length;i++){
//        	 abc    012
//        	 a.b.c  024
        	 c[i*2] = arr[i];
        	 if(i*2+1<c.length-1)
        		 c[i*2+1]='.';
        }
        
        // maxLength track longest width excluding center-> abcba = 2
        // maxMid track the center character 
        int maxWidth =1, maxMid =0;
        for(int i = 0; i<c.length; i++){
        	int max = longestPalindromeHelper(i, c);
        	if(max>maxWidth){
        		maxWidth = max;
        		maxMid =i;
        	}
        }
        // now we need to find out whether center character was inserted by us or not
        // -> characters at odd indices were inserted afterward
        // if maxMid is odd -> x.b.a.a.b.y
        // if maxMid is even => x.b.a.b.y
        if(maxMid%2==1){
        	// x.b.a.a.b.y, mid = 5, maxWidth = 4(".b.a", "a.b.")
        	StringBuilder sb = new StringBuilder();
        	for(int i =0; i*2< maxWidth/2; i++){
        		sb.append(arr[maxMid+i*2+1]);
        	}
        	sb = sb.reverse().append(sb);
        	return sb.toString();
        } else {
        	// x.b.a.b.y, mid = 3, maxWidth = 4(".b.", ".b.")
        	StringBuilder sb = new StringBuilder();
        	for(int i =2; i< maxWidth; i+=2){
        		sb.append(arr[maxMid+i]);
        	}
        	StringBuilder left = sb.reverse();
        	left.append(arr[maxMid]);
        	left.append(sb);
        	return left.toString();
        }
        

    }
	
	// x x x i x x x -> 3, center is i, left 3 and right 3 are reversed
	public int longestPalindromeHelper(int center, char[] arr){
		
		int i = 0;
		while(center-i>=0 && center+1<=arr.length-1){
			if(arr[center-i]!=arr[center+i]){
				return i;
			}
			i++;
		}
		
		return i-1;
	}
}