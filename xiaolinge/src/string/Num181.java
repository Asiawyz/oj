package string;

public class Num181 {

    public static void main(String[] args) {

    }

    public String dynamicPassword(String password, int target) {
        StringBuilder sb = new StringBuilder(password.length());
        sb.append(password.substring(target));
        for (int i = 0; i < target; i++) {
            sb.append(password.charAt(i));
        }
        return sb.toString();
    }
}
