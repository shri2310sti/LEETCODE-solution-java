import java.util.List;
import java.util.ArrayList;

class Solution {
    public List<Integer> findWordsContaining(String[] words, char targetChar) {
        List<Integer> indicesWithTargetChar = new ArrayList<>();
      
        for (int index = 0; index < words.length; ++index) {
            if (words[index].indexOf(targetChar) != -1) {
                indicesWithTargetChar.add(index);
            }
        }
        return indicesWithTargetChar;
    }
}
