class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if(digits == null || digits.length() == 0) {
            return result;
        }
        
        HashMap<Character, String> hm = new HashMap<>();
        hm.put('2', "abc");
        hm.put('3', "def");
        hm.put('4', "ghi");
        hm.put('5', "jkl");
        hm.put('6', "mno");
        hm.put('7', "pqrs");
        hm.put('8', "tuv");
        hm.put('9', "wxyz");
        
        backtrack(result, hm, digits, 0, new StringBuilder());
        return result;
    }
    
    private void backtrack(List<String> result, HashMap<Character, String> hm, String digits, int index, StringBuilder current) {

        if(index == digits.length()) {
            result.add(current.toString());
            return;
        }
        
        String letters = hm.get(digits.charAt(index));
        for(int i = 0; i < letters.length(); i++) {
            current.append(letters.charAt(i));
            backtrack(result, hm, digits, index + 1, current);
            current.deleteCharAt(current.length() - 1);  // backtrack
        }
    }
}
