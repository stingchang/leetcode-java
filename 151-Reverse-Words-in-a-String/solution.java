public class Solution {
    public String reverseWords(String s) {
		String[] arr = s.split("\\s+");
		StringBuilder sb = new StringBuilder();
		for(String st: arr){
			sb.append(reverse(st)+ " ");
		}

		return sb.reverse().substring(1);
	}
	String reverse(String s){
		char[] arr = s.toCharArray();
		int a =0, b = arr.length-1;
		while(a<b){
			char c = arr[a];
			arr[a] = arr[b];
			arr[b] = c;
		}
		return new String(arr);
	}
}