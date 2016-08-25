public class Solution {
    public int firstUniqChar(String s) {
        // 1. use a hashmap and a queue to track frequency of each character
        // 2. pop up characters from queue until current character appears only once
        
        Map<Character, Integer> map  = new HashMap<>();
        Queue<Character> queue  = new LinkedList<>();
        for(int i =0; i< s.length(); i++){
            char c = s.charAt(i);
            if(map.containsKey(c)){
              map.put(c, map.get(c)+1);
            } else {
                map.put(c, 1);
            }
            queue.add(c);
        }
        int i = 0;
        while(!queue.isEmpty()){
            char c = queue.remove();
            if(map.get(c) == 1)
                return i;
            i++;
        }
        
        return -1;
    }
}