import java.util.*;

class Solution {
    public String countOfAtoms(String formula) {
        Stack<Map<String, Integer>> stack = new Stack<>();
        stack.push(new HashMap<>());
        
        int i = 0;
        int n = formula.length();
        
        while (i < n) {
            if (formula.charAt(i) == '(') {
                stack.push(new HashMap<>());
                i++;
            } else if (formula.charAt(i) == ')') {
                i++;
                int start = i;
                while (i < n && Character.isDigit(formula.charAt(i))) i++;
                int multiplier = start < i ? Integer.parseInt(formula.substring(start, i)) : 1;
                Map<String, Integer> top = stack.pop();
                Map<String, Integer> current = stack.peek();
                for (String key : top.keySet()) {
                    current.put(key, current.getOrDefault(key, 0) + top.get(key) * multiplier);
                }
            } else {
                int start = i;
                i++; // move past the first uppercase letter
                while (i < n && Character.isLowerCase(formula.charAt(i))) i++;
                String element = formula.substring(start, i);
                start = i;
                while (i < n && Character.isDigit(formula.charAt(i))) i++;
                int count = start < i ? Integer.parseInt(formula.substring(start, i)) : 1;
                Map<String, Integer> current = stack.peek();
                current.put(element, current.getOrDefault(element, 0) + count);
            }
        }
        
        Map<String, Integer> finalCounts = stack.pop();
        List<String> sortedElements = new ArrayList<>(finalCounts.keySet());
        Collections.sort(sortedElements);
        
        StringBuilder result = new StringBuilder();
        for (String element : sortedElements) {
            result.append(element);
            int count = finalCounts.get(element);
            if (count > 1) result.append(count);
        }
        
        return result.toString();
    }
}
