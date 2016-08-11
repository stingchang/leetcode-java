public class Solution {
 public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
		if (beginWord == endWord)
			return 1;
		if(wordList.contains(beginWord))
			wordList.remove(beginWord);
		wordList.add(endWord);

		Set<String> visiting = new HashSet<>();
	
		visiting.add(beginWord);

		return dfs(visiting, wordList, endWord, 0);

	}

	int dfs(Set<String> visiting, Set<String> wordList, String end, int level) {
		
		
		Set<String> nextlevel = new HashSet<>();
		while (!visiting.isEmpty()) {
			level++;
//		System.out.println(visiting.contains(end)+" "+visiting);
			if(visiting.contains(end))
				return level;
			for (String s : visiting) {
				for (int i = 0; i < s.length(); i++) {
					char cur = s.charAt(i);
					// for(int i =0; i< 26; i++){
					for (int j = 0; j < 26; j++) {
						char c = (char) ('a' + j);

						if (c != cur) {
							String newStr = s.substring(0, i) + c + s.substring(i + 1);
	
							// System.out.println("newStr = "+newStr);
							if (wordList.contains(newStr)) {
								if (newStr.equals( end))
									return level+1;
								nextlevel.add(newStr);
								wordList.remove(newStr);
							}
						}
					}

				}
			}
			visiting.clear();
			visiting.addAll(nextlevel);
			nextlevel.clear();
		}

		return 0;
	}
}