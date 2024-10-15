package day20241015;

import java.util.LinkedList;
import java.util.List;

/**
 * @author by asia
 * @Classname Num17
 * @Description TODO
 * @Date 2024/10/15 17:37
 */
public class Num17 {

    public static void main(String[] args) {
        String s = "";
        new Num17().letterCombinations(s);
    }

    String[] ss = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    List<String> ans;

    public List<String> letterCombinations(String digits) {
        ans = new LinkedList<>();
        if (digits.isEmpty()) {
            return ans;
        }
        assemble(0,digits,"");
        return ans;
    }

    public void assemble(int i, String digits, String s) {
        if (i == digits.length()){
            ans.add(s);
            System.out.println(s);
            return;
        }
        char ch = digits.charAt(i);
        String str = ss[((int) ch) - 48];
        for (int j = 0; j < str.length(); j++) {
            assemble(i + 1,digits,s + str.charAt(j));
        }
    }
}
