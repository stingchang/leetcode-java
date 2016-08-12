public class Solution {
   s = s.trim();
		System.out.println("\""+s+"\"");
		int len = s.length() ;
		
		char[] arr = s.toCharArray();
		int a = 0, b = len - 1;
		// " xxxx xx x xx ", reverse sub array between front and end spaces
		// " xx x xx xxxx "
		while (a<len && arr[a] == ' ') {
			a++;
		}

		while (b>=0 && arr[b] == ' ') {
			b--;
		}
		if(a>=b)
			return s;
		reverse(arr, a, b);

		// " 123 12 1 123" reverse each sub string
		// " 321 21 1 321"
		int c = a;
		while (a < b) {
			while (c < b && arr[c] != ' ') {
				c++;
			}
			reverse(arr, a, c-1);
			a = c + 1;
			while (a < b && arr[a] == ' ') {
				a++;
			}
		}
		return new String(arr);
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