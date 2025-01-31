class Solution {
    public boolean isPalindrome(int x) {
        if(x<0) return false;
        int temp = x;
        
        int index = 0;
        
        while(temp>0){
            int digit = temp % 10;
            temp/=10;
            index++;
        }
        
        int arr[] = new int[index];
        
        int count = 0;
        int temp2 = x;
        while(temp2>0){
            int digit = temp2 % 10;
            arr[count] = digit;
            temp2 /= 10;
            count++;
        }
        
        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i] + " ");
        }
        for(int i=0; i<arr.length; i++){
            if(arr[i] != arr[arr.length -1 - i]) return false;
        }
        return true;
        
    }
}