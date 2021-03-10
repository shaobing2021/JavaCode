package leetcode.lc0;

public class AddTwoNumbers {
    public static void main(String[] args) {
//        ListNode m1 = new ListNode(2);
//        ListNode m2 = new ListNode(4);
//        ListNode m3 = new ListNode(3);
//        m1.next = m2;
//        m2.next = m3;
//        ListNode n1 = new ListNode(5);
//        ListNode n2 = new ListNode(6);
//        ListNode n3 = new ListNode(4);
//        n1.next = n2;
//        n2.next = n3;
        ListNode m1 = new ListNode(1);
        ListNode n1 = new ListNode(9);
        ListNode n2 = new ListNode(9);
        n1.next = n2;
        ListNode node = addTwoNumbers(m1, n1);
        while (node!=null){
            System.out.println(node.val);
            node = node.next;
        }
    }
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1==null) return l2;
        if (l2==null) return l1;
        int k = 0;
        int v = l1.val+l2.val;
        if (v>9){
            v = v%10;
            k=1;
        }else {
            k=0;
        }
        ListNode start = new ListNode(v);
        ListNode p = start;
        l1 = l1.next;
        l2 = l2.next;
        while (l1!=null&&l2!=null){
             v = l1.val+l2.val+k;
            if (v>9){
                v= v%10;
                k=1;
            }else {
                k = 0;
            }
            ListNode node = new ListNode(v);
            p.next = node;
            p = node;
            l1 = l1.next;
            l2 = l2.next;
        }
        if (l2!=null) {
            l1 = l2;
            l2 = null;
        }
        while (l1!=null){
            v = l1.val+k;
            if (v>9){
                v = v%10;
                k = 1;
            }else {
                k = 0;
            }
            ListNode node = new ListNode(v);
            p.next = node;
            p = node;
            l1 = l1.next;
        }
        if (l1==null&&l2==null&&k!=0){
            p.next = new ListNode(1);
        }
        return start;
    }
}
