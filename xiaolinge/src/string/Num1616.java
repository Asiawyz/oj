package string;

public class Num1616 {

    public static void main(String[] args) {
        String a = "abdef";
        String b = "fecab";
        System.out.println(new Num1616().checkPalindromeFormation(a, b));
    }

    public boolean checkPalindromeFormation(String a, String b) {
        return checkConnect(a, b) || checkConnect(b, a);
    }

    private boolean checkConnect(String a, String b) {
        int left = 0, right = a.length() - 1;
        while (left < right) {
            if (a.charAt(left) == b.charAt(right)) {
                ++left;
                --right;
            } else {
                break;
            }
        }
        if (left >= right) {
            return true;
        }
        return check(a, left, right) || check(b, left, right);
    }

    public boolean check(String a, int left, int right) {
        char[] chars = a.toCharArray();
        while (left < right) {
            if (chars[left++] != chars[right--]) {
                return false;
            }
        }
        return true;
    }

}
