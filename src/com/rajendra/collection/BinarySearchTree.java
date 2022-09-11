package com.rajendra.collection;

import com.rajendra.model.TreeInfo;
import com.rajendra.model.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by Rajendra Verma on 30/08/22.
 */
public class BinarySearchTree extends BinaryTree {
    private TreeNode current = root;
    private TreeNode prev = null;
    private int minAbsoluteDifferene;

    @Override
    public void buildTree(int[] data) {
        for (int i = 0; i < data.length; i++) {
            this.root = insert(this.root, data[i]);
        }

    }

    public void insert(int data) {
        this.root = insert(this.root, data);
    }

    public boolean search(int val) {

        return searchRec(this.root, val);
    }

    private boolean searchRec(TreeNode root, int key) {
        if (root == null)
            return false;
        if (key < root.left.val) {
            return searchRec(root.left, key);
        } else if (root.val == key) {
            return true;
        } else {
            return searchRec(root.right, key);
        }

    }

    public void delete(int key) {
        this.root = deleteRec(this.root, key);
    }

    private TreeNode deleteRec(TreeNode root, int key) {
//        based on sorting
        if (root.val > key) {
            root.left = deleteRec(root.left, key);
        } else if (root.val < key) {
            root.right = deleteRec(root.right, key);
        } else {

            // case 1 leaf Node
            if (root.left == null && root.right == null) {
                return null;
            }


            // case 2 root.left =null
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }

            //             case 3 inorder successor
            TreeNode is = inorderSuccessor(root.right);
            root.val = is.val;
            root.right = deleteRec(root.right, is.val);


        }
        return root;
    }

    //    left most element in right successor
    private TreeNode inorderSuccessor(TreeNode root) {
        while (root.left != null)
            root = root.left;

        return root;
    }


    private TreeNode insert(TreeNode root, int data) {
        if (root == null) {
            root = new TreeNode(data);
            return root;
        }
//         the smaller value always goes to the left side of tree and vice vera
        if (data < root.val) {
            root.left = insert(root.left, data);
        } else {
            root.right = insert(root.right, data);
        }

        return root;
    }

    public void printInRange(int x, int y) {

        printInRangeRec(this.root, x, y);
    }

    private void printInRangeRec(TreeNode root, int x, int y) {
        if (root == null) return;
        if (root.val >= x && root.val <= y) {
            printInRangeRec(root.left, x, y);
            System.out.print(root.val + ",");
            printInRangeRec(root.right, x, y);
        } else if (root.val >= y) {
            printInRangeRec(root.left, x, y);
        } else {
            printInRangeRec(root.right, x, y);
        }


    }

    private void printRootToLeaf() {
        ArrayList<Integer> path = new ArrayList<>();
        printRootToLeafRec(root, path);

    }

    private void printRootToLeafRec(TreeNode root, ArrayList<Integer> path) {
        if (root == null)
            return;
        path.add(root.val);
        if (root.left == null && root.right == null) {
            printPath(path);
        } else {
            printRootToLeafRec(root.left, path);
            printRootToLeafRec(root.right, path);
        }
        path.remove(path.size() - 1);

    }

    private void printPath(ArrayList<Integer> path) {
        for (int val : path) {
            System.out.print(val + "->");
        }
        System.out.print("END");
        System.out.println();
    }

    private TreeNode sortedArrayToBstRec(int[] nums) {
        return sortedArrayToBstRec(nums, 0, nums.length - 1);
    }


    public TreeNode sortedArrayToBstRec(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = (start + end) / 2;
        TreeNode treeNode = new TreeNode(nums[mid]);
        treeNode.left = sortedArrayToBstRec(nums, start, mid - 1);
        treeNode.right = sortedArrayToBstRec(nums, mid + 1, end);
        return treeNode;
    }

    public int[] findMode() {
        Map<Integer, Integer> map = new HashMap<>();
        if (this.root.left == null && this.root.right == null) {
            return new int[]{this.root.val};
        }
// frequncy Map
        progress(this.root, map);
        List<Map.Entry<Integer, Integer>> list =
                new LinkedList<Map.Entry<Integer, Integer>>(map.entrySet());

        // Sort the list
        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
            public int compare(Map.Entry<Integer, Integer> o1,
                               Map.Entry<Integer, Integer> o2) {
                return (o1.getValue()).compareTo(o2.getValue());
            }
        });

        int singleModeValue = list.get(list.size() - 1).getValue();
        if (list.size() == 0)
            return new int[]{0};
        int count = list.size() - 1;
        List<Integer> ans = new ArrayList<>();
//        collecting the similar   mode value
        while (count >= 0) {

            int key = list.get(count).getKey();
            int val = list.get(count).getValue();
            if (singleModeValue == val)
                ans.add(key);


            count--;
        }
        ArrayList d = (ArrayList) ans;
        d.trimToSize();
        Integer array[] = ((List<Integer>) d).toArray(new Integer[d.size()]);  //2
        int[] a = new int[array.length];

        for (int i = 0; i < array.length; i++) {
            a[i] = array[i];
        }
        return a;

    }


    private void progress(TreeNode root, Map<Integer, Integer> map) {
        if (root == null)
            return;
        if (map.containsKey(root.val)) {
            map.put(root.val, map.get(root.val) + 1);
        } else {
            map.put(root.val, 1);
        }
        progress(root.left, map);
        progress(root.right, map);

    }


    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        int data[] = {2,2,2};
        bst.buildTree(data);
        System.out.println( "Valid BST"+bst.isValidBST());

    }

    private TreeNode listCommonAnsisters(int p, int q) {
        return listCommonAnsistersRec(root, p, q);


    }

    private TreeNode listCommonAnsistersRec(TreeNode root, int n1, int n2) {

        if (root == null)
            return null;

        if (root.val > n1 && root.val > n2)
            return listCommonAnsistersRec(root.left, n1, n2);

        if (root.val < n1 && root.val < n2)
            return listCommonAnsistersRec(root.right, n1, n2);

        return root;

    }

    public int getMinimumDifference() {
        return getMinimumDifference(this.root);
    }

/*
Algorithm
1. Take two pointers current and previous
2. perform inorder traversal with current
3. point the  previous  just prev with current
4. min the iterative min at the visitor point
5. return the min

 */


    public int getMinimumDifference(TreeNode root) {
        current = root;
        prev = null;
        minAbsoluteDifferene = Integer.MAX_VALUE;

        inOrder(current);
        return minAbsoluteDifferene;
    }

    private void inOrder(TreeNode curr) {
        if (curr == null)
            return;
        inOrder(curr.left);

        if (prev != null)
            minAbsoluteDifferene = Math.min(curr.val -
                    prev.val, minAbsoluteDifferene);
        prev = curr;
        inOrder(curr.right);


    }

    public void searchBST(int key) {
        TreeNode d = searchRecBST(this.root, key);
        this.root = d;
        levelOrderDisplay();
    }

    private TreeNode searchRecBST(TreeNode root, int key) {
        if (root == null || root.left == null)
            return null;

        if (key < root.val) {
            return searchRecBST(root.left, key);
        } else if (root.val == key) {
            return root;
        } else {
            return searchRecBST(root.right, key);
        }

    }


    public int rangeSumBST(TreeNode root, int low, int high) {
        TreeInfo info = new TreeInfo();
        rangeSumBSTRec(root, low, high, info);
        return info.sumRange;
    }

    private void rangeSumBSTRec(TreeNode root, int low, int high, TreeInfo info) {
        if (root == null)
            return;

        if (low<=root.val || high>= root.val){
            info.sumRange = info.sumRange+root.val;
        }
        rangeSumBSTRec(root.left,low,high,info);
        rangeSumBSTRec(root.right,low,high,info);
    }


    public  boolean isValidBST(){
        return isValidBST(this.root);
    }
    private boolean isValidBST(TreeNode root) {
        if (root == null)
            return true;

        /* False if left is > than node */
        if (root.left != null && root.left.val > root.val)
            return false;

        /* False if right is < than node */
        if (root.right != null && root.right.val < root.val)
            return false;

        /* False if, recursively, the left or right is not a BST
         */
        if (!isValidBST(root.left) || !isValidBST(root.right))
            return false;

        /* Passing all that, it's a BST */
        return true;
    }
}



