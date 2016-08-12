public class Solution {
   public String reverseWords(String s) {
		s = s.trim();
//		System.out.println("s = "+s);
		String[] arr = s.split("\\s+");
		System.out.println(Arrays.toString(arr));
		if (arr.length == 0)
			return "";
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < arr.length; i++) {
			
			sb.append(reverse(arr[i]));
//			System.out.println("here");
			if (i < arr.length - 1) {
				sb.append(" ");
			}
		}
//		System.out.println("sb = "+sb);
		return sb.reverse().toString();
	}

	String reverse(String s) {
		char[] arr = s.toCharArray();
		int a = 0, b = arr.length - 1;
		while (a < b) {
			char c = arr[a];
			arr[a] = arr[b];
			arr[b] = c;
			a++;
			b--;
		}
		return new String(arr);
	}
}