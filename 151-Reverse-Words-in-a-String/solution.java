public class Solution {
    public String reverseWords(String s) {
		String[] arr = s.split("\\s+");
		if(arr.length ==0)
		    return "";
		StringBuilder sb = new StringBuilder();
		for(int i =0; i< arr.length; i++){
			sb.append(reverse(arr[i]));
			if(i<arr.length-1){
			    sb.append(" ");    
			}
		}

		return sb.reverse();
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