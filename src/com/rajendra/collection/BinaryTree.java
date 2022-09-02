package com.rajendra.collection;

import com.rajendra.model.TreeInfo;
import com.rajendra.model.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Rajendra Verma on 28/08/22.
 */
public class BinaryTree {
    int index = -1;
    public TreeNode root;


    public void buildTree(int data[]) {
        root = buildTreeRec(data);
    }

    private TreeNode buildTreeRec(int data[]) {
        index++;
        if (data[index] == -1) {
            return null;
        }
//        pre order traversal
        TreeNode newNode = new TreeNode(data[index]);
        newNode.left = buildTreeRec(data);
        newNode.right = buildTreeRec(data);
        return newNode;
    }


    public void preOrderDisplayRec(TreeNode node) {
        if (node == null) {
            return;
        }
        System.out.print(node.val);
        System.out.print(",");
        preOrderDisplayRec(node.left);
        preOrderDisplayRec(node.right);


    }

    private void postOrderDisplay() {
        postOrderDisplayRec(root);
    }

    private void postOrderDisplayRec(TreeNode root) {
        if (root == null) return;
        postOrderDisplayRec(root.left);
        postOrderDisplayRec(root.right);
        System.out.print(root.val + ",");
    }

    public void inOrderDisplay() {
        inOrderDisplayRec(root);
    }

    private void inOrderDisplayRec(TreeNode root) {
        if (root == null) return;
        inOrderDisplayRec(root.left);
        System.out.print(root.val + ",");
        inOrderDisplayRec(root.right);


    }

    public boolean isSubtree(TreeNode subRoot) {

        return isSubTreeRec(root, subRoot);


    }


    private boolean isIdentical(TreeNode root, TreeNode subtree) {
        if (root == null && subtree == null) {
            return true;
        }
        if (root == null && subtree != null) {
            return false;
        }
        if (root != null && subtree == null) {
            return false;
        }
        if (root.val != subtree.val) {
            return false;
        }

        return isIdentical(root.left, subtree.left) && isIdentical(root.right, subtree.right);
    }

    private boolean isSubTreeRec(TreeNode root, TreeNode subtree) {

        if (root == null) {
            return false;
        }
        if (subtree == null)
            return true;

        if (root.val == subtree.val) {

            return isIdentical(root, subtree) || isSubTreeRec(root.left, subtree) || isSubTreeRec(root.right, subtree);

        }

        return isSubTreeRec(root.left, subtree) || isSubTreeRec(root.right, subtree);
    }

    private void preOrderDisplay() {
        preOrderDisplayRec(root);
    }


    //    Level order iteration
//BFS  travarsal
    public void levelOrderDisplay() {
        if (root == null) return;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        queue.add(null);
        while (!queue.isEmpty()) {
            TreeNode node = queue.remove();
            if (node == null) {
                System.out.println();
                if (queue.isEmpty())
                    break;
                else queue.add(null);
            } else {
                System.out.print(node.val + ",");
                if (node.left != null)
                    queue.add(node.left);
                if (node.right != null)
                    queue.add(node.right);
            }


        }
    }

    public int size() {
        int size = countOfNodes(root);
        return size;
    }

    public int sum() {

        int sum = sumOfNodes(root);
        return sum;
    }

    private int sumOfNodes(TreeNode root) {
        if (root == null)
            return 0;
        int left = sumOfNodes(root.left);
        int right = sumOfNodes(root.right);
        return left + right + root.val;
    }

    private int countOfNodes(TreeNode root) {
        if (root == null)
            return 0;
        int left = countOfNodes(root.left);
        int right = countOfNodes(root.right);

        return left + right + 1;
    }


    public int diameter() {
        TreeInfo diameter = diameterRecII(root);
        return diameter.diameter;
    }

    //    ON^2
    private int diameterRec(TreeNode root) {
        if (root == null)
            return 0;
        int left = diameterRec(root.left);
        int right = diameterRec(root.right);
        int rootNode = heightOfTree(root.left) + heightOfTree(root.right) + 1;
        return Math.max(rootNode, Math.max(left, right));
    }

    //    ON^1
    private TreeInfo diameterRecII(TreeNode root) {
        if (root == null) {
            TreeInfo treeInfo = new TreeInfo(0, 0);
            return treeInfo;

        }

        TreeInfo left = diameterRecII(root.left);
        TreeInfo right = diameterRecII(root.right);
        int myheight = Math.max(left.height, right.height) + 1;
        int d1 = left.diameter;
        int d2 = right.diameter;
        int d3 = left.height + right.height + 1;
        int diameter = Math.max(Math.max(d1, d2), d3);

        TreeInfo myInfo = new TreeInfo(myheight, diameter);

        return myInfo;
    }


    public static void main(String[] args) {
//        pre-order
        BinarySearchTree a = new BinarySearchTree();
        int[] data = {1, 2, 3};
        a.buildTree(data);
        BinarySearchTree b = new BinarySearchTree();
        b.buildTree(data);
        System.out.println("Tree is same " + b.isSameTree(a.root, b.root));
    }

    private int sumOfNodesAtLength(int k) {
        if (root == null) return 0;
        int sum = 0;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        queue.add(null);
        int level = 1;
        while (!queue.isEmpty()) {
            TreeNode node = queue.remove();
            if (node == null) {
                level++;
                if (queue.isEmpty())
                    break;
                else queue.add(null);
            } else {
                if (level == k) {
                    sum += node.val;
                }
                if (node.left != null)
                    queue.add(node.left);
                if (node.right != null)
                    queue.add(node.right);
            }
        }
        return sum;
    }

    private int height() {

        int height = heightOfTree(root);
        return height;
    }

    static boolean flag = false;

    public boolean isSameTree(TreeNode p, TreeNode q) {
        ;
        return isSameTreeRec(p, q);
    }

    public boolean isSameTreeRec(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null) {
            return false;
        }
        if (q == null) {
            return false;
        }

        flag = isSameTreeRec(p.left, q.left);
        if (p.val != q.val) {
            return false;
        }
        flag = isSameTreeRec(p.right, q.right);

        return flag;
    }

    private int heightOfTree(TreeNode root) {
        if (root == null)
            return 0;
        int left = heightOfTree(root.left);
        int right = heightOfTree(root.right);
        return Math.max(left, right) + 1;
    }

    public boolean isBalanced() {

        return isBalanced(this.root);
    }


    private boolean isBalanced(TreeNode node) {
        int lh;
        int rh;
        if (node == null)
            return true;
        lh = heightOfTree(node.left);
        rh = heightOfTree(node.right);
        if (Math.abs(lh - rh) <= 1 && isBalanced(node.left)
                && isBalanced(node.right))
            return true;
        return false;
    }



    public boolean isSymmetric(TreeNode node) {
        return isSymmetric(this.root, node);
    }

    private boolean isSymmetric(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        if (left == null || right == null) return false;
        if (left.val != right.val) return false;
        if (!isSymmetric(left.left, right.right))
            return false;
        if (!isSymmetric(left.right, right.left))
            return false;
        return true;
    }
}
