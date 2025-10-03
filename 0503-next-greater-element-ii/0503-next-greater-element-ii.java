class Solution {
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> s = new Stack<>();
        int[] arr = new int[nums.length];

        Arrays.fill(arr, -1);

        for(int i = 2*nums.length-1; i >= 0; i--){
            while(!s.isEmpty() && nums[i%nums.length] >= s.peek())s.pop();
            if(i<nums.length){
                if(!s.isEmpty()) arr[i] = s.peek();
            }
            s.push(nums[i%nums.length]);
        }
        return arr;

        // //approach 1
        // int[] arr = new int[nums.length];
        // Arrays.fill(arr, -1);

        // for(int i=0; i<nums.length; i++){
        //     for(int j=i+1; j<i+nums.length; j++){
        //         int idx = j%nums.length;
        //         if(nums[i] < nums[idx]) {
        //             arr[i] = nums[idx];
        //             break;
        //         }
        //     } 
        // }
        // return arr;
    }
}