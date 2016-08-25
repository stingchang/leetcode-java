public class Solution {
    public boolean canJump(int[] nums) {
        int jump = nums[0];
        int i = 0;
        while(jump!=0 && i<nums.length){
            i = i+jump;
            
            jump = nums[i] < nums.length? nums[i]: 0 ;
        }   
        
        if(i == nums.length-1)
            return true;
        return false;    
    }
}