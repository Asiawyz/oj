package day20241028;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @author by asia
 * @Classname Num763
 * @Description TODO
 * @Date 2024/10/28 20:58
 */
public class Num763 {

    public static void main(String[] args) {
        String s = "eccbbbbdec";
        List<Integer> list = new Num763().partitionLabels(s);
        for (int x : list) {
            System.out.println(x);
        }
    }

    public List<Integer> partitionLabels(String s) {
        Map<Character, Integer> map = new HashMap<>(26);
        char[] chars = s.toCharArray();
        int n = s.length();
        for (int i = 0; i < n; i++) {
            map.put(chars[i], i);
        }
        List<Integer> ans = new LinkedList<>();
        int start = 0;
        while (start < n) {
            int left = start;
            int end = map.get(chars[start]);
            while (start != end) {
                ++start;
                int index = map.get(chars[start]);
                if (index > end) {
                    end = index;
                }
            }
            ans.add(end - left + 1);
            ++start;
        }
        return ans;

    }
}
