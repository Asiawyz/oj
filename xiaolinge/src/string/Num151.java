package string;

import java.util.ArrayList;
import java.util.List;

public class Num151 {

    public static void main(String[] args) {
        String s = "the sky is blue";
        System.out.println(new Num151().reverseWords(s));
    }

    public String reverseWords(String s) {
        char[] charArray = s.toCharArray();
        int index = 0;
        int n = charArray.length;
        List<String> list = new ArrayList<>();
        while (true) {
            while (index < n && charArray[index] == ' ') {
                ++index;
            }
            if (index == n) {
                break;
            }
            StringBuilder sb = new StringBuilder();
            while (index < n && charArray[index] != ' ') {
                sb.append(charArray[index++]);
            }
            list.add(sb.toString());
        }
        StringBuilder sb = new StringBuilder();
        int size = list.size();
        for (int i = size - 1; i >= 0; i--) {
            sb.append(list.get(i));
            if (i > 0) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }
}
