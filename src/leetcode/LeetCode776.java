package leetcode;

/**
 * title: 776. Split BST
 * level: Medium
 * source: LeetCode Weekly Contest 70
 * link: https://leetcode.com/contest/weekly-contest-70/problems/split-bst/
 * explanation：利用递归操作二叉搜索树，需要对递归和二叉搜索树有深刻理解。
 */
public class LeetCode776 {
    /**
     * Definition for a binary tree node.
     **/
     public class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode(int x) { val = x; }
     }
    public TreeNode[] splitBST(TreeNode root, int V) {
        if (root == null)
            return new TreeNode[]{null, null};
        if (root.val == V) {
            TreeNode right = root.right;
            root.right = null;
            return new TreeNode[]{root, right};
        }
        else if (root.val > V) {
            TreeNode[] nodes = splitBST(root.left, V);
            TreeNode left = nodes[0];
            TreeNode right = nodes[1];
            root.left = right;
            return new TreeNode[]{left,root};
        } else {
            TreeNode[] nodes = splitBST(root.right, V);
            TreeNode left = nodes[0];
            TreeNode right = nodes[1];
            root.right=left;
            return new TreeNode[]{root, right};
        }

    }
}
