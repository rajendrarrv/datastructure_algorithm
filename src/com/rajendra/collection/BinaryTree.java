package com.rajendra.collection;

import com.rajendra.model.TreeInfo;
import com.rajendra.model.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
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
        if (index >= data.length)
            return null;
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
        int totalHeightOfTree = heightOfTree(root.left) + heightOfTree(root.right) + 1;
        return Math.max(totalHeightOfTree, Math.max(left, right));
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
//        [3,4,5,1,2]
        int rootData[] = {1, 3, 5, -1, -1, 2, -1, -1};
        int rootSubTree[] = {2, 1, -1, 4, -1, -1, 3,-1,7,-1,-1};
        BinaryTree rootRoot = new BinaryTree();
        rootRoot.buildTree(rootData);
        System.out.println("Root");
        rootRoot.levelOrderDisplay();
        System.out.println("Sub tree");
        BinaryTree subRoot = new BinaryTree();
        subRoot.buildTree(rootSubTree);
        subRoot.levelOrderDisplay();
        rootRoot.merge(subRoot.root);
        System.out.println("Merge result");
        rootRoot.levelOrderDisplay();

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

    public int minDepth() {
        return minDepth(this.root);
    }

    private int minDepth(TreeNode root) {
        if (root == null)
            return 0;

        if (root.left == null && root.right == null)
            return 1;

        if (root.left == null)
            return minDepth(root.right) + 1;

        if (root.right == null)
            return minDepth(root.left) + 1;

        return Math.min(minDepth(root.left),
                minDepth(root.right)) + 1;
    }

    public boolean hasPathSum(int targetSum) {

        return hasPathSum(root, targetSum);
    }

    int sum = 0;

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;

        hasPathSum(root.left, targetSum);
        if (targetSum < sum) {
            sum = sum + root.val;
        } else if (targetSum == sum)
            return true;

        hasPathSum(root.right, targetSum);
        return false;
    }

    public boolean hasPath(TreeNode root, int target, int sum) {
        return hasPathSumRec(root, target, sum);
    }

    private boolean hasPathSumRec(TreeNode root, int target, int sum) {
        if (root == null) {
            return false;
        }
        sum = sum + root.val;
        if (sum == target && root.right == null && root.left == null) {
            return true;
        }
        boolean IsNotPathSum = hasPathSumRec(root.left, target, sum) ||
                hasPathSumRec(root.right, target, sum);
        sum = sum - root.val;
        return IsNotPathSum;

    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> answer = new LinkedList<>();
        preorderTraversalRec(root, answer);

        return answer;

    }

    private void preorderTraversalRec(TreeNode root, List<Integer> answer) {
        if (root == null)
            return;

        answer.add(root.val);
        preorderTraversalRec(root.left, answer);
        preorderTraversalRec(root.right, answer);

    }

    public TreeNode invertTree(TreeNode root) {

        invertTreeRec(root);
        return root;

    }

    private TreeNode invertTreeRec(TreeNode node) {
        if (node == null)
            return node;

        /* recursive calls */
        TreeNode left = invertTreeRec(node.left);
        TreeNode right = invertTreeRec(node.right);

        /* swap the left and right pointers */
        node.left = right;
        node.right = left;

        return node;

    }

    public List<String> binaryTreePaths() {
        Deque<Integer> path = new ArrayDeque<>();
        List<String> ans = new ArrayList<>();
        binaryTreePathsRec(root, path, ans);
        return ans;
    }

    private void binaryTreePathsRec(TreeNode root, Deque<Integer> path, List<String> ans) {
        // base case
        if (root == null) {
            return;
        }
        path.addLast(root.val);
        if (isLeaf(root)) {
            StringBuilder sb = new StringBuilder();
            ArrayList list = new ArrayList(path);
            for (int i = 0; i < list.size(); i++) {
                sb.append(list.get(i) + "->");
            }
            CharSequence sequence = sb.subSequence(0, sb.length() - 2);
            ans.add(sequence.toString());
        }

        binaryTreePathsRec(root.left, path, ans);
        binaryTreePathsRec(root.right, path, ans);
        if (!path.isEmpty())
            path.removeLast();
    }

    public int leftLeavesSum() {
        return leftLeavesSumRec(this.root);
    }


    int leftLeavesSumRec(TreeNode node) {
        int res = 0;
        if (node != null) {
            if (isLeaf(node.left))
                res += node.left.val;
            else
                res += leftLeavesSumRec(node.left);
            res += leftLeavesSumRec(node.right);
        }
        return res;
    }

    public boolean isLeaf(TreeNode node) {
        return (node.left == null && node.right == null);
    }


    public int findTilt() {
        return findTilt(this.root);
    }

    private int findTilt(TreeNode root) {

        TreeInfo t = new TreeInfo(0);
        tiltInOrderTraverse(root, t);
        return t.tilt;

    }

    private int tiltInOrderTraverse(TreeNode root, TreeInfo t) {
        if (root == null)
            return 0;

        int left = tiltInOrderTraverse(root.left, t);
        int right = tiltInOrderTraverse(root.right, t);
        t.tilt += Math.abs(left - right);

        return left + right + root.val;
    }

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null)
            return true;
        if (subRoot == null)
            return false;
        if (isIdentical(subRoot, root))
            return true;
        return isSubtree(subRoot.left, root)
                || isSubtree(subRoot.right, root);
    }

    StringBuilder str = new StringBuilder();

    public String toSTR() {
        treeToString(this.root);
        return str.toString();
    }


    public void treeToString(TreeNode root) {
//      todo will solve later
        // bases case
        if (root == null) {
//            str.append("()");
            return;
        }
        str.append(root.val);
        // for left subtree
        if (root.left != null)
            str.append("(");

        treeToString(root.left);
        if (root.right != null)
            str.append(")");

        treeToString(root.right);


    }

    public void merge(TreeNode subtree) {
        merge(this.root, subtree);
    }
    TreeNode mergeTree = new TreeNode(0);

    private void merge(TreeNode root, TreeNode subtree) {

        this.root =mergeTreeRec(root, subtree);;
        levelOrderDisplay();
    }

    private TreeNode mergeTreeRec(TreeNode root, TreeNode subtree) {
        if (root == null)
            return subtree;
        if (subtree == null)
            return root;
        root.val += subtree.val;
        root.left = mergeTreeRec(root.left, subtree.left);
        root.right = mergeTreeRec(root.right, subtree.right);
        return root;
        }

}

