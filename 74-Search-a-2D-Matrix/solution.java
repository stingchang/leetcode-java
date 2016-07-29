public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0 || matrix[0]==0)
            return false;
        binarySearch(matrix, target, matrix[0].length, 0, matrix[0].length* matrix.length-1);
    }
    
    public boolean binarySearch(int arr[][], target, int len, int a, int b){
        if(b<a) 
            return false;
        int mid = a+(b-a)/2;
        int r = mid/len;
        int c = mid%len;
        if(arr[r][c] == target)
            return true;
        if(arr[r][c] < target){
            return binarySearch(arr, target, len, mid+1, b);
        }   else {
            return binarySearch(arr, target, len, a, mid-1);
        } 
    }
}