package list;

import java.util.*;

public class Num347 {

    public static void main(String[] args) {
        int[] nums = {4,1,-1,2,-1,2,3};
        System.out.println(Arrays.toString(new Num347().topKFrequent2(nums, 2)));
    }

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int x : nums) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }
        int[][] a = new int[map.size()][2];
        int i = 0;
        for (int x : map.keySet()) {
            a[i][0] = map.get(x);
            a[i][1] = x;
            ++i;
        }
        Arrays.sort(a, Comparator.comparingInt(b -> b[0])); // 按照第一个元素排序
        int[] ans = new int[k];
        i = 0;
        for (int j = a.length - 1; i < k; j--) {
            ans[i++] = a[j][1];
        }
        return ans;
    }

    public int[] topKFrequent2(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int x : nums) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }

        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int num = entry.getKey();
            int count = entry.getValue();
            if (queue.size() < k) {
                queue.add(new int[]{num, count});
            } else {
                if (queue.peek()[1] < count) {
                    queue.poll();
                    queue.add(new int[]{num, count});
                }
            }
        }
        int[] ans = new int[k];
        int i = 0;
        for (int j = 0; j < k; j++) {
            ans[i++] = queue.poll()[0];
        }
        return ans;
    }
}
