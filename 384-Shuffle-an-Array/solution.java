public class Solution {

    int[] nums;
	public Solution(int[] nums) {
	      this.nums = nums;
	}

	/** Resets the array to its original configuration and return it. */
	public int[] reset() {
		return nums;
	}

	/** Returns a random shuffling of the array. */
	public int[] shuffle() {
		int len = nums.length;
		int[] newArr = nums.clone();
		
		Random r = new Random();
		for(; len>0; len--){
			int randomLoc = r.nextInt(len);
//			System.out.println(randomLoc);
			// swap len and randomLoc
			int tmp = newArr[len-1];
			newArr[len-1] = newArr[randomLoc]; 
			newArr[randomLoc] = tmp;
		}
		
		
		return newArr;
	}
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */