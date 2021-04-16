package offer.lc5.lc0to5;

import leetcode.lc0.ListNode;

public class GetIntersectionNode {
    //该解法是由于假设heada长度a，headb长度b，公共长度c，则a+(b-c) = b+（a-c）
    public ListNode getIntersectionNode(ListNode headA,ListNode headB){
        if (headA==null||headB==null) return null;
        ListNode tempa = headA,tempb= headB;
        while (tempa!=tempb){
            //最终至少会指向a b
            tempa=tempa==null?headB:tempa.next;
            tempb=tempb==null?headA:tempb.next;
        }
        return tempa;
    }
    //常规解法应该是找到a，b长度，从同一个节点开始
    public ListNode getIntersectionNode1(ListNode headA,ListNode headB){
        if (headA==null||headB==null) return null;
        int lenA=0,lenB=0;
        ListNode tempA = headA,tempB=headB;
        /**
         * 统计节点长度可以抽取出来
         */
        while (headA!=null){
            lenA++;
            headA=headA.next;
        }
        while (headB!=null){
            lenB++;
            headB=headB.next;
        }
        if (lenA>lenB){
            int temp = lenA - lenB;
            for (int i = 0; i < temp; i++) {
                tempA = tempA.next;
            }
        }else {
            int temp = lenB - lenA;
            for (int i = 0; i < temp; i++) {
                tempB = tempB.next;
            }
        }
        while (tempA!=tempB){
            tempA=tempA.next;
            tempB=tempB.next;
        }
        return tempA;
    }
}
