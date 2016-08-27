public class Solution {
   public List<List<Integer>> combinationSum(int[] candidates, int target) {

		List<List<Integer>> lists = new ArrayList<>();
		List<Integer> list = new ArrayList<>();
		Arrays.sort(candidates);
		
		builLists(candidates, candidates.length - 1, target, list, lists);
		return lists;
	}

	public void builLists(int[] a, int i, int target, List<Integer> list, List<List<Integer>> lists) {
		if (target < 0 || i < 0)
			return;
		if (target == 0) {
			
			lists.add(list);
		} else {
			
			List<Integer> nlist = new ArrayList<Integer>(list);
			nlist.add(a[i]);
			builLists(a, i, target-a[i], nlist,lists) ;
			List<Integer> nlist2 = new ArrayList<Integer>(list);
			builLists(a, i-1, target, nlist2,lists) ;
		}
	}

}