package day20241029;

import java.util.HashSet;
import java.util.Set;

/**
 * @author by asia
 * @Classname Num968
 * @Description TODO
 * @Date 2024/10/29 15:11
 */
public class Num968 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(1);
        root.left.left = new TreeNode(2);
        root.left.left.left = new TreeNode(3);

        System.out.println(new Num968().minCameraCover(root));
    }

    Set<Tree> set;
    int count;
    public int minCameraCover(TreeNode root) {
        set = new HashSet<>();
        Tree head = new Tree(null, null, null);
        head.left = new Tree(null, null, head);
        count = 1;
        buildTree(head.left, root);
        dfs(head.left);
        return set.size();
    }

    public void buildTree(Tree head, TreeNode root) {
        if (root.left != null) {
            head.left = new Tree(null, null, head);
            ++count;
            buildTree(head.left, root.left);
        }
        if (root.right != null) {
            head.right = new Tree(null, null, head);
            ++count;
            buildTree(head.right, root.right);
        }
    }

    public void dfs(Tree root) {
        if (root == null) {
            return;
        }
        dfs(root.left);
        dfs(root.right);
        if (checkLeaf(root)) {
            setCamera(root);
        }
    }

    public void setCamera(Tree root) {
        if (root.father == null) {
            set.add(root);
        } else {
            Tree father = root.father;
            if (set.contains(father)) {
                return;
            }
            set.add(father);
            color(father);
            color(father.left);
            color(father.right);
            color(father.father);
        }
    }

    public void color(Tree root) {
        if (root != null) {
            root.flag = true;
        }
    }

    public boolean checkLeaf(Tree root) {
        if (root.flag) {
            return false;
        }
        if (root.left == null && root.right == null) {
            return true;
        }
        boolean flag = true;
        if (root.left != null) {
            flag = root.left.flag;
        }
        if (root.right != null) {
            flag = flag && root.right.flag;
        }
        return flag;
    }

    class Tree {
        boolean flag;
        Tree left;
        Tree right;
        Tree father;

        Tree(Tree left, Tree right, Tree father) {
            flag = false;
            this.left = left;
            this.right = right;
            this.father = father;
        }

        @Override
        public int hashCode() {
            return super.hashCode();
        }

        @Override
        public boolean equals(Object obj) {
            return super.equals(obj);
        }
    }
}
