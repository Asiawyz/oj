package day20241010;

import java.util.ArrayList;
import java.util.List;

/**
 * @author by asia
 * @Classname Num501
 * @Description TODO
 * @Date 2024/10/15 13:47
 */
public class Num501 {



    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(2);
        int[] mode = new Num501().findMode(root);
        for (int j : mode) {
            System.out.println(j);
        }
    }

    List<Integer> list;
    int count;
    int max;
    int pre;

    public int[] findMode(TreeNode root) {
        list = new ArrayList<>();
        list.add(root.val);
        count = 0;
        max = 0;
        pre = -1;
        dfs(root);
        int n = list.size();
        int[] ans = new int[n];
        int index = 0;
        for (int x : list) {
            ans[index++] = x;
        }
        return ans;
    }

    public void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root.left);
        if (root.val == pre) {
            ++count;
        } else {
            pre = root.val;
            count = 1;
        }
        update();
        dfs(root.right);
    }

    public void update() {
        if (count > max) {
            max = count;
            list.clear();
            list.add(pre);
        } else if (count == max) {
            list.add(pre);
        }
    }
}
