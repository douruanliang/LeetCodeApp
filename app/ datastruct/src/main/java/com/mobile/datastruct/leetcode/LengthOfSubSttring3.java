package com.mobile.datastruct.leetcode;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * @author: douruanliang
 * @date: 2020/10/5
 */
public class LengthOfSubSttring3 {

    public static void main(String[] args) {
        LengthOfSubSttring3 lengthOfSubSttring3 = new LengthOfSubSttring3();
        System.out.println(lengthOfSubSttring3.lengthOfLongsSubString("abcabcbb"));
       //
        // System.out.println(lengthOfSubSttring3.lengthOfLongestSubString("abcabcbb"));
    }



    private int lengthOfLongsSubString(String s){
        int left = 0, right = 0, max = 0;
        Set<Character> set = new HashSet<>();
        while (right < s.length()) {
            if (set.contains(s.charAt(right))) { // a
                set.remove(s.charAt(left++)); // ?
            } else {
                set.add(s.charAt(right++));
                max = Math.max(max, set.size());
            }
        }

        Iterator<Character> it = set.iterator();
        while (it.hasNext()){
            System.out.println("------");
           char item = it.next();
            System.out.println(item);
        }


        return max;
    }

    private int lengthOfLongestSubString(String s){

        if(s == null){
            return  -1;
        }

        int front = 0;
        int back = 0;
        int max = 0;

        Set<Character> set = new HashSet<>();

        while (front < s.length()){
            char currentChar = s.charAt(front);
            if (!set.contains(currentChar)){
                set.add(currentChar);
                int currentLength = front - back +1;
                if (currentLength > max){
                    max = currentLength;
                }
            }else{
                // 说明包含
                char  backChar = s.charAt(back); //0 -p

                while (backChar!=currentChar){ // p  w
                    set.remove(backChar);
                    ++back;
                    backChar = s.charAt(back);
                }
                ++back;

            }

            ++front;
        }

        System.out.println(set.size());
        for (char ss : set){
            System.out.println(ss);

        }
        return  max;
    }
}
