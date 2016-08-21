public class Solution {
    public String reverseString(String s) {
        char[] arr = s.toCharArray();
        int a = 0; 
        int b = arr.length-1;
        while(a<b){
            char c = arr[a];
            arr[a] = arr[b];
            arr[b] = c;
            a++;
            b--;
        }
        
        return new String(arr);
    }
}