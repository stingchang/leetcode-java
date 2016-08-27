public class Solution {
   public List<List<Integer>> combinationSum(int[] candidates, int target) {

		List<List<Integer>> lists = new ArrayList<>();
		List<Integer> list = new ArrayList<>();
		Arrays.sort(candidates);
		builLists(candidates, 0, target, list, lists);
		return lists;
	}

	public void builLists(int[] a, int i, int target, List<Integer> list, List<List<Integer>> lists) {
		int cur = target-a[i];
		List<Integer> newList = new ArrayList<>(list);
		newList.add(a[i]);
		if(cur == 0){
			lists.add(newList);
		}
		else if(cur < 0){
			return;
		} else {
			builLists(a,i,target, list, lists);
			if(i<a.length-1)
				builLists(a,i+1,target, list, lists);
		}
	}

}