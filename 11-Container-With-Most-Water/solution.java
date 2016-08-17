public class Solution {
    public int maxArea(int[] height) {
	        if(height.length<=1)
	            return 0;
	        
	        int a = 0, b = height.length-1;
	        int max = Math.min(height[a],height[b]) * (b-a);
	        while(b>a){
	            
	            int b2 = b;
	            while(b2>a && height[b2]<=height[b]){
	                b2--;
	            }
	            int volR = Math.min(height[a],height[b2]) * (b2-a);
	            
	            int a2 = a;
	            while(a2<b && height[a2]<=height[a]){
	                a2++;
	            }
	            int volL = Math.min(height[a2],height[b]) * (b-a2);
	            
	            if(volL>volR){
	                a = a2;
	                max = Math.max(volL, max);
	            } else {
	                b = b2;
	                max = Math.max(volR, max);
	            }
	        }
	        return max;
	    }
}