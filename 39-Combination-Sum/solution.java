public class Solution {
   	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		Arrays.sort(candidates);
		List<List<Integer>> lists = new ArrayList<>();

		List<Integer> list = new ArrayList<>();
		buildLists(lists, list, candidates, candidates.length - 1, target);
		return lists;
	}

	public void buildLists(List<List<Integer>> lists, List<Integer> list, int[] arr, int index, int target) {

		if (target < 0 || index < 0) {
			return;
		}

		else if (target == 0) {
			
			lists.add(list);
		} else {

			// don't take current value
			List<Integer> l1 = new ArrayList<>(list);
			buildLists(lists, l1, arr, index - 1, target);

			// take current
			
			List<Integer> l2 = new ArrayList<>(list);
			l2.add(arr[index]);
			buildLists(lists, l2, arr, index, target - arr[index]);
		}

		// = 0: take cur or not
		// < 0: not
		// > 0: take cur or not
	}

}