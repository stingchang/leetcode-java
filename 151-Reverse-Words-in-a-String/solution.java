public class Solution {
    public String reverseWords(String s) {
        char[] arr = s.toCharArray();
        int a = 0, b = arr.length-1;
        // "  xxxx xx x xx ", reverse sub array between front and end spaces
        // "  xx x xx xxxx "
        while(arr[a]==' '){
            a++;
        }
        while(arr[b]==' '){
            b--;
        }
        reverse(arr, a, b);
        
        // " 123 12 1 123" reverse each sub string
        // " 321 21 1 321"
        int c = a;
        while(a<b){
            while(c<b && arr[c]!=' '){
                c++;
            }
            reverse(arr, a, c);
            a = c+1;
            while(a<b && arr[a]==' '){
                a++;
            }
        }
        return arr.toString();
    }
    void reverse(char[] arr, int a, int b){
        while(a<b){
            char tmp = arr[a];
            arr[a] = arr[b];
            arr[b] = tmp;
            a++;
            b--;
        }
    }
}