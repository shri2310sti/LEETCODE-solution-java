import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<String> removeSubfolders(String[] folder) {
        // Sort the folder list lexicographically
        Arrays.sort(folder);
        
        List<String> result = new ArrayList<>();
        
        // Add the first folder to the result
        result.add(folder[0]);
        
        // Iterate through the sorted folders
        for (int i = 1; i < folder.length; i++) {
            String prevFolder = result.get(result.size() - 1);
            
            // Check if the current folder is a subfolder of the last added folder
            if (!folder[i].startsWith(prevFolder + "/")) {
                result.add(folder[i]);
            }
        }
        
        return result;
    }
}
