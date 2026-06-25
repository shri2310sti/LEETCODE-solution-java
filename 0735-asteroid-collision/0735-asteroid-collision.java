import java.util.*;

class Solution {
    public int[] asteroidCollision(int[] arr) {
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < arr.length; i++) {

            if (!st.isEmpty() && arr[i] < 0 && st.peek() > 0) {

                // Remove all smaller positive asteroids
                while (!st.isEmpty()
                        && st.peek() > 0
                        && Math.abs(arr[i]) > st.peek()) {
                    st.pop();
                }

                // Collision with a remaining positive asteroid
                if (!st.isEmpty() && st.peek() > 0) {

                    // Equal size: both explode
                    if (st.peek() == Math.abs(arr[i])) {
                        st.pop();
                    }

                    // Current asteroid is destroyed
                    continue;
                }

                // No positive asteroid left, current survives
                st.push(arr[i]);

            } else {
                st.push(arr[i]);
            }
        }

        int[] ans = new int[st.size()];
        for (int i = ans.length - 1; i >= 0; i--) {
            ans[i] = st.pop();
        }

        return ans;
    }
}