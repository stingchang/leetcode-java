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
		
		
		
		while (!visiting.isEmpty()) {
			level++;
//		System.out.println(visiting.contains(end)+" "+visiting);
			if(visiting.contains(end))
				return level;
			Set<String> nextlevel = new HashSet<>();
			for (String s : visiting) {
				char[] charArr = s.toCharArray();
				for (int i = 0; i < s.length(); i++) {
					char cur = charArr[i];
					// for(int i =0; i< 26; i++){
					for (char j = 'a'; j <= 'z'; j++) {
//						char c = (char) ('a' + j);
						
						if (j != charArr[i]) {
							char[] charArr2 = charArr.clone();
							charArr2[i]=j;
							String newStr = new String(charArr2);
							if (newStr.equals( end))
								return level+1;
							// System.out.println("newStr = "+newStr);
							if (wordList.contains(newStr)) {
//								
								nextlevel.add(newStr);
								wordList.remove(newStr);
							}
						}
					}

				}
			}
			visiting = new HashSet<>();
			visiting.addAll(nextlevel);
//			nextlevel.clear();
		}

		return 0;
	}

}