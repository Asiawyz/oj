package array;

public class Num88 {

    public static void main(String[] args) {

    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int index = n + m - 1, i = m - 1, j = n - 1;
        while (i >= 0 && j >=0) {
            if (nums1[i] < nums2[j]) {
                nums1[index--] = nums2[j--];
            } else {
                nums1[index--] = nums1[i--];
            }
        }
        while (j >= 0) {
            nums1[index--] = nums2[j--];
        }
    }
}
