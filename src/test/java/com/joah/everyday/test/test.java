package com.joah.everyday.test;

import java.util.HashMap;
import java.util.Map;

public class test {

    /**
     * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
     * 输出：7 -> 0 -> 8
     * 原因：342 + 465 = 807
     * @param args
     */
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.addTwoNumbers(new ListNode(243), new ListNode(546));
    }

    static class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            Map<Integer,Integer> maps = new HashMap<>(8);

            while (true){

            }
        }
    }


    public static class ListNode {
        int val;
        ListNode next;   // 下一个链表对象
        ListNode(int x) { val = x; }  //赋值链表的值
    }

}
