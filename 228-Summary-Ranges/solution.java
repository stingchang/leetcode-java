public class Solution {
    public List<String> summaryRanges(int[] nums) {
        	List<String> list = new ArrayList<>();
		if (nums == null || nums.length == 0)
			return list;
		int start = 0, end = 0;
		for (int i = 0; i < nums.length; i++) {
			if (i != nums.length - 1) {

				if (nums[i + 1] - nums[i] == 1) {
					end++;
				} else {
					if (start == end) {
						list.add(nums[start] + "");

					} else {
						list.add(nums[start] + "->" + nums[end]);
					}
					start = end = i + 1;
				}
			} else {
				if (start == end) {
					list.add(nums[start] + "");

				} else {
					list.add(nums[start] + "->" + nums[end]);
				}
				start = end = i + 1;
			}
		}
		return list;
    }
}