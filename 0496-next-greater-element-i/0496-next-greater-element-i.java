class Solution {
    // TC Total: O(n + m), SC : O(n)

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> s = new Stack<>();
        Map<Integer, Integer> map = new HashMap<>();

        for(int i = nums2.length - 1; i >= 0; i--){
            while(!s.isEmpty() && s.peek() < nums2[i]) s.pop();
            if(s.isEmpty()) map.put(nums2[i],-1);
            else map.put(nums2[i], s.peek());
            s.push(nums2[i]);
        }
        int[] arr = new int[nums1.length];
        for(int i=0; i<nums1.length; i++){
            arr[i] = map.get(nums1[i]);
        }
        return arr;
    }
}