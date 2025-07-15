class Solution {
    public boolean isValid(String word) {
        if(word.length() < 3) return false;

        int vowel = 0;
        int consonant = 0;
        
        for(int i = 0; i < word.length(); i++){
           if(Character.isLetter(word.charAt(i))){
            if(word.charAt(i) == 'a' || word.charAt(i) == 'e' || word.charAt(i) == 'i' || word.charAt(i) == 'o' || word.charAt(i) == 'u' || word.charAt(i) == 'A' || word.charAt(i) == 'E' || word.charAt(i) == 'I' || word.charAt(i) == 'O' || word.charAt(i) == 'U') vowel++;
            else consonant++;
           }

           else if(!Character.isDigit(word.charAt(i))) return false;
        }
        return (vowel >= 1 && consonant >= 1);
    }
}