package com.rajendra;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by Rajendra Verma on 18/09/22.
 */
public class HashTableImpl {

    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (!set.add(nums[i])) return true;
        }

        return false;
    }

    public int singleNumber(int[] nums) {
        HashMap<Integer, Integer> numCount = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {

            if (numCount.containsKey(nums[i])) {
                int val = numCount.get(nums[i]);
                val = val + 1;
                numCount.put(nums[i], val);
            } else {

                numCount.put(nums[i], 1);
            }
        }
        for (Map.Entry<Integer, Integer> entry : numCount.entrySet()) {
            System.out.printf("key %d and val %d", entry.getKey(), entry.getValue());
            System.out.println();
            if (entry.getValue() < 2) {
                return entry.getKey();
            }
        }
        return -1;
    }


    public int firstUniqChar(String s) {
        char[] chars = s.toCharArray();
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < chars.length; i++) {
            if (map.containsKey(chars[i])) {
                int val = map.get(chars[i]);
                val = val + 1;
                map.put(chars[i], val);

            } else {
                map.put(chars[i], 1);

            }
        }
        map.forEach((key, value) -> {
            System.out.println(key + "->" + value);
        });

        return -1;
    }

    public int[] intersect(int[] nums1, int[] nums2) {


        if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0) {
            return new int[0];
        }

        int i = 0;
        int j = 0;

        Arrays.sort(nums1);
        Arrays.sort(nums2);

        List<Integer> result = new ArrayList<>();

        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j]) {
                result.add(nums1[i]);
                i++;
                j++;
            } else if (nums1[i] < nums2[j]) {
                i++;
            } else {
                j++;
            }
        }
        System.out.println(result);
        // Convert list to array
        return toArray(result);
    }

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {

            if (set.contains(nums[i])) return true;
            set.add(nums[i]);
            if (set.size() > k)
                set.remove(nums[i - k]);
        }
        return false;
    }


    private int[] toArray(List<Integer> res) {
        int result[] = new int[res.size()];
        Iterator<Integer> iterate = res.iterator();
        int index = 0;
        while (iterate.hasNext()) {

            result[index] = iterate.next();
            index++;
        }


        return result;
    }

    public static void main(String[] args) {
        HashTableImpl hashTable = new HashTableImpl();
        System.out.println(hashTable.containsNearbyDuplicate(new int[]{1, 2, 3, 1, 2, 3}, 2));
    }

}
