package string;

public class Num541 {

    public static void main(String[] args) {
        String s = "abcdefg";
        System.out.println(new Num541().reverseStr(s, 2));
    }

    public String reverseStr(String s, int k) {
        int n = s.length();
        char[] chars = s.toCharArray();
        for (int l = 0; l < n; l = l + 2 * k) {
            int r = l + k - 1;
            reverseString(chars, l, Math.min(r, n - 1));
        }
        return String.valueOf(chars);

    }

    public void reverseString(char[] s, int left, int right) {
        while (left < right) {
            char ch = s[left];
            s[left] = s[right];
            s[right] = ch;
            ++left;
            --right;
        }
    }
}
