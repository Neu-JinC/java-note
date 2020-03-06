package leetcode.medium;

import lombok.Getter;
import lombok.Setter;

import java.util.Optional;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
public class AddTwoNum {

    public static void main(String[] args) {
//        ListNode l3 = new ListNode(3);
//        ListNode l2 = new ListNode(4);
        ListNode l1 = new ListNode(5);
//        l1.next = l2;
//        l2.next = l3;

//        ListNode ll3 = new ListNode(6);
//        ListNode ll2 = new ListNode(6);
        ListNode ll1 = new ListNode(5);

//        ll1.next = ll2;
//        ll2.next = ll3;

        ListNode listNode = addTwoNumbers(l1, ll1);
        do {
            System.out.println(listNode.val);
            listNode = listNode.next;
        } while (listNode != null);



    }


    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return generateNode(l1,l2, 0);
    }

    private static ListNode generateNode(ListNode l1, ListNode l2, Integer carry) {

        Integer value1 = Optional.ofNullable(l1).map(listNode -> listNode.val).orElse(0);
        Integer value2 = Optional.ofNullable(l2).map(listNode -> listNode.val).orElse(0);

        Integer newValue = (value1 + value2 + carry) % 10;
        Integer nexCarry = (value1 + value2 + carry) / 10;

        ListNode newListNode = new ListNode(newValue);

        ListNode nextNodeL1 = Optional.ofNullable(l1).map(listNode -> listNode.next).orElse(null);
        ListNode nextNodeL2 = Optional.ofNullable(l2).map(listNode -> listNode.next).orElse(null);

        if(nextNodeL1 != null|| nextNodeL2 != null || nexCarry > 0) {
            newListNode.next = generateNode(nextNodeL1, nextNodeL2, nexCarry);
        }

        return newListNode;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
     }
}
