public class Solution {
    public boolean canJump(int[] nums) {
        int cur = nums[0];
        int i = 0;
        while(cur!=0 && i<nums.length){
            i = i+cur;
            cur = nums[i];
        }   
        
        if(i == nums.length-1)
            return true;
        return false;    
    }
}