import java.util.*;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int max = 0;

        // Handle empty or single-char strings safely
        if (s.length() <= 1) {
            return s.length();
        }

        for (int i = 0; i < s.length(); i++) {
            // Track characters seen in the current substring starting at i
            Set<Character> seen = new HashSet<>();
            seen.add(s.charAt(i));
            int count = 1; // substring length starting from i including s.charAt(i)

            for (int j = i + 1; j < s.length(); j++) {
                char c = s.charAt(j);
                if (seen.contains(c)) {
                    // duplicate found, stop expanding this substring
                    break;
                } else {
                    seen.add(c);
                    count++;
                }
            }

            if (count > max) {
                max = count;
            }
        }

        return max;
    }
}
