package array;

/**
 * @author by asia
 * @Classname Num2383
 * @Description Num2383
 * @Date 2024/9/26 12:06
 */
public class Num2383 {

    public static void main(String[] args) {
//        int[] a = {1, 4, 3, 2};
//        int[] b = {2, 6, 3, 1};
        int[] a = {1, 4};
        int[] b = {2, 5};
        System.out.println(new Num2383().minNumberOfHours(5,3,a,b));
    }

    public int minNumberOfHours(int initialEnergy, int initialExperience, int[] energy, int[] experience) {
        int ans = 0;
        for (int i = 0; i < energy.length; i++) {
            int x = energy[i];
            int y = experience[i];
            if (initialEnergy <= x) {
                ans += x - initialEnergy + 1;
                initialEnergy = x + 1;
            }
            if (initialExperience <= y) {
                ans += y - initialExperience + 1;
                initialExperience = y + 1;
            }
            initialEnergy -= x;
            initialExperience += y;
        }
        return ans;
    }


}
