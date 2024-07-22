import java.util.*;

class Solution {
    public String[] sortPeople(String[] names, int[] heights) {
        // Create a list to hold pairs of (name, height)
        List<Pair<String, Integer>> people = new ArrayList<>();
        
        // Populate the list with the names and heights
        for (int i = 0; i < names.length; i++) {
            people.add(new Pair<>(names[i], heights[i]));
        }
        
        // Sort the list by height in descending order
        Collections.sort(people, (a, b) -> b.getValue() - a.getValue());
        
        // Extract the names from the sorted list
        String[] sortedNames = new String[names.length];
        for (int i = 0; i < people.size(); i++) {
            sortedNames[i] = people.get(i).getKey();
        }
        
        return sortedNames;
    }
    
    // Helper class to represent a pair of name and height
    private static class Pair<K, V> {
        private K key;
        private V value;
        
        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }
        
        public K getKey() {
            return key;
        }
        
        public V getValue() {
            return value;
        }
    }
}
