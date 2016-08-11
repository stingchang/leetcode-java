public class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> lists = new ArrayList<>();
        buildLists(lists, new ArrayList<Integer>(), candidates.length-1, target);
    }
    void buildLists(List<List<Integer>> lists , List<Integer> list , int index, int[] candidates, int target){
        if(target < 0 || index<0){
            return;
        }
        else if(target == 0){
            lists.add(list);
            return;
        } else {
            List<Integer> l1 = new ArrayList<>(list);
            l1.add(candidates[index]);
            buildLists(lists, l1, index-1, candidates, target-candidates[index]);
            
            List<Integer> l2 = new ArrayList<>(list);
            buildLists(lists, l2, index-1, candidates, target);
        }
    }
    
}