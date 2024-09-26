package array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author by asia
 * @Classname Num3
 * @Description Num3
 * @Date 2024/9/25 17:44
 */
public class Num3 {

    public static void main(String[] args) {

    }

    public int lengthOfLongestSubstring(String s) {
        if (s.length() < 1) {
            return 0;
        }
        Set<Character> set = new HashSet<>();
        int ans = 1;
        char[] chars = s.toCharArray();
        int left = 0, right = 1, n = s.length();
        set.add(chars[left]);
        while (right < n) {
            while (right < n && !set.contains(chars[right])) {
                set.add(chars[right++]);
            }
            if (right == n) {
                ans = Math.max(ans, right - left);
                break;
            }
            ans = Math.max(ans, right - left);
            char ch = chars[right];
            while (set.contains(ch)) {
                set.remove(chars[left++]);
            }
        }
        return ans;
    }

    public int lengthOfLongestSubstring2(String s) {
        int max = 0;
        Map<Character,Integer> map = new HashMap<>(s.length());
        int len = 0;
        int start = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (map.containsKey(ch) && start <= map.get(ch)){
                start = map.get(ch) + 1;
                len = i - map.get(ch);
            } else {
                ++len;
            }
            map.put(ch,i);
            max = Math.max(len, max);
        }
        return max;
    }
}
