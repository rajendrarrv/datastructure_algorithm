package com.rajendra.practice.exculsive;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Created by Rajendra Verma on 19/09/22.
 */
class MyHashMap {
    private int[] _v;

    public MyHashMap() {
        _v = new int[1000001];
        for (int i = 0; i < _v.length; i++) {
            _v[i] = -1;
        }
    }

    public void put(int key, int value) {
        _v[key] = value;
    }

    public int get(int key) {
        return _v[key];
    }

    public void remove(int key) {
        _v[key] = -1;
    }


    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        if (strs.length < 2) {
            List<String> strings  = new ArrayList<>();
            strings.add("\"\"");
            result.add(strings);
            return result;
        }
        for (int i = 0; i < strs.length; i++) {
            String s = strs[i];
            char[] schar = s.toCharArray();
            Arrays.sort(schar);
            StringBuilder sb = new StringBuilder();
            sb.append(schar);
            map.put(sb.toString(), new ArrayList<>());
        }

        for (int i = 0; i < strs.length; i++) {
            String s = strs[i];
            char[] schar = s.toCharArray();
            Arrays.sort(schar);
            StringBuilder sb = new StringBuilder();
            sb.append(schar);

            if (map.containsKey(sb.toString())){
                map.get(sb.toString()).add(s);

            }

        }
        Iterator<List<String>>  d  = map.values().iterator();
        while (d.hasNext()){
            result.add(d.next());
        }
        return result;
    }

    public static void main(String[] args) {
        MyHashMap map = new MyHashMap();
        System.out.println(  map.groupAnagrams(new String[]{""}));
    }

    private boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        char[] schar = s.toCharArray();
        char[] tchar = t.toCharArray();
        Arrays.sort(schar);
        Arrays.sort(tchar);
        for (int i = 0; i < schar.length; i++) {

            if (schar[i] != tchar[i]) return false;
        }
        return true;
    }
}

