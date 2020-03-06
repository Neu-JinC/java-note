package leetcode.medium;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

import java.util.*;
import java.util.stream.Collectors;

/**
 * 开始时间：10：50
 *
 */
public class DeleteRepeatItem {
    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(-3);
        ListNode listNode2 = new ListNode(-3);
        ListNode listNode3 = new ListNode(-2);
        ListNode listNode4 = new ListNode(-1);
        ListNode listNode5 = new ListNode(-1);
//        ListNode listNode6 = new ListNode(1);
//        ListNode listNode7 = new ListNode(6);
//        ListNode listNode8 = new ListNode(7);
//        ListNode listNode9 = new ListNode(8);
//        ListNode listNode10 = new ListNode(9);

        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
//        listNode5.next = listNode6;
//        listNode6.next = listNode7;
//        listNode7.next = listNode8;
//        listNode8.next = listNode9;
//        listNode9.next = listNode10;
//        listNode10.next = null;

        ListNode head = deleteDuplicates(listNode1);
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }

    public static ListNode deleteDuplicates(ListNode head) {
        if(head == null) {
            return null;
        }

        //构建初始节点
        ListNode preIndexNode = head;
        ListNode indexNode = head;
        while (preIndexNode != null && preIndexNode.next != null) {

            Boolean isDelete = Boolean.FALSE;

            //循环的开始节点
            ListNode preNode = indexNode;
            //循环删除相同节点
            while (preNode != null && preNode.next != null) {
                ListNode tempNode = preNode.next;
                //删除相同节点
                if(indexNode.val == tempNode.val) {
                    preNode.next = tempNode.next;
                    isDelete = Boolean.TRUE;
                } else {
                    preNode = preNode.next;
                }
            }

            //删除本节点
            if(isDelete) {
                if(head == indexNode) {
                    //删除首节点
                    head = indexNode.next;
                    preIndexNode = head;
                } else {
                    preIndexNode.next = indexNode.next;
                }
                //删除本节点，pre不变，pre.next变动
            } else {
                if(head == indexNode) {
                    preIndexNode.next = indexNode.next;
                } else {
                    preIndexNode = preIndexNode.next;                }
            }

            indexNode = indexNode.next;
        }
        return head;
    }

    public static ListNode deleteDuplicates2(ListNode head) {
        if(head == null) {
            return null;
        }

        Map<Integer, Integer> valueMap = new LinkedHashMap<>();
        while (head != null) {
            if(valueMap.get(head.val) == null) {
                valueMap.put(head.val, 1);
            } else  {
                valueMap.put(head.val, valueMap.get(head.val) + 1);
            }
            head = head.next;
        }

        List<Map.Entry<Integer, Integer>> valueMapList = new ArrayList<Map.Entry<Integer, Integer>>(valueMap.entrySet());
        valueMapList = valueMapList.stream().filter(integerIntegerEntry -> {return integerIntegerEntry.getValue() == 1;}).collect(Collectors.toList());

        if (valueMapList == null || valueMapList.isEmpty()) {
            return null;
        }
        ListNode dummy = new ListNode(-1);
        ListNode currentNode = null;
        for(Integer index = 0; index < valueMapList.size(); index++) {
            ListNode tempNode = new ListNode(valueMapList.get(index).getKey());
            if(index == 0) {
                currentNode = tempNode;
                dummy.next = currentNode;
            } else {
                currentNode.next =tempNode;
                currentNode = currentNode.next;
            }
        }

        return dummy.next;
    }
}

