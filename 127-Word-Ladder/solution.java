public class Solution {
    	public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
		if (beginWord == endWord)
			return 0;

		Set<String> visiting = new HashSet<>();
		int depth = 1;
		visiting.add(beginWord);
		if (wordList.contains(beginWord)) {
			wordList.remove(beginWord);
		}
		while (!visiting.isEmpty()) {
			dfs(visiting, wordList);
			depth++;
			if (visiting.contains(endWord))
				return depth;
		}

		return 0;
	}

	void dfs(Set<String> visiting, Set<String> wordList) {

		Set<String> nextlevel = new HashSet<>();

		for (String s : visiting) {
			for (int i = 0; i < s.length(); i++) {
				char cur = s.charAt(i);
				// for(int i =0; i< 26; i++){
				for(int j =0; j<26; j++){
					char c = (char) ('a' + j);

					if (c != cur) {
						String newStr = s.substring(0, i) + c + s.substring(i + 1);
//						System.out.println("newStr = "+newStr);						
						if (wordList.contains(newStr)) {
							nextlevel.add(newStr);
							wordList.add(newStr);
						}
					}	
				}
			}
		}
		visiting.clear();
		visiting.addAll(nextlevel);
	}
}