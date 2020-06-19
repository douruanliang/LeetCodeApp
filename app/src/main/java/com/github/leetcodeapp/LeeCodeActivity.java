package com.github.leetcodeapp;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: dourl
 * @date: 2020/6/5
 */
public class LeeCodeActivity {

    public static void main(String[] args) {
        String a = "abcdbc";
        System.out.println("----{0}");
        int result = lengthLongestSubstring(a);
        System.out.println("----{1}" + result);

    }


    public static int lengthLongestSubstring(String s) {

        int left = 0;
        int right = 0;

        int n = s.length();

        int max = 0;
        boolean[] used = new boolean[128];

        while (right < n) {
            if (used[s.charAt(right)] == false) {
                used[s.charAt(right)] = true;
                right++;
            } else {
                max = Math.max(max, right - left);
                while (left < right && s.charAt(right) != s.charAt(left)) {
                    used[s.charAt(left)] = false;
                    left++;
                }

                left++;
                right++;
            }

        }

        max = Math.max(max, right - left);

        return max;
    }


    public int lengthOfLongestSubstring(String s) {
        //用链表实现队列，队列是先进先出的
        Queue<Character> queue = new LinkedList<>();
        int res = 0;
        for (char c : s.toCharArray()) {
            while (queue.contains(c)) {
                //如果有重复的，队头出队
                queue.poll();
            }
            //添加到队尾
            queue.add(c);
            res = Math.max(res, queue.size());
        }
        return res;
    }

}
