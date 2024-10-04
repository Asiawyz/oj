package string;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Stack;

public class Num20 {

    public static void main(String[] args) {

    }

    public boolean isValid(String s) {
        Deque<Character> deque = new ArrayDeque<>();
        char[] charArray = s.toCharArray();
        for (char ch : charArray) {
            if (ch == '(' || ch == '[' || ch == '{') {
                deque.addLast(ch);
            } else {
                if (deque.isEmpty()) {
                    return false;
                }
                char c = deque.removeLast();
                if (!check(c, ch)) {
                    return false;
                }
            }
        }
        return deque.isEmpty();
    }

    public boolean check(char l, char r) {
        if (l == '(') {
            return r == ')';
        }
        if (l == '[') {
            return r == ']';
        }
        if (l == '{') {
            return r == '}';
        }
        return false;
    }
}
