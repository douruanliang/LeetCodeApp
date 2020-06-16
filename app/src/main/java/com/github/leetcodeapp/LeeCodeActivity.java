package com.github.leetcodeapp;

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
}
