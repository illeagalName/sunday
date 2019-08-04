package com.seventh.sunday.vo;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        while(l1.next != null){
            list1.add(l1.val);
            l1 = l1.next;
        }
        while(l2.next != null){
            list2.add(l2.val);
            l2 = l2.next;
        }

        return null;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}