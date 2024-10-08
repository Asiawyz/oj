package string;

public class Num344 {

    public static void main(String[] args) {

    }

    public void reverseString(char[] s) {
        int left = 0, right = s.length;
        while (left < right) {
            char ch = s[left];
            s[left] = s[right];
            s[right] = ch;
            ++left;
            --right;
        }
    }
}
