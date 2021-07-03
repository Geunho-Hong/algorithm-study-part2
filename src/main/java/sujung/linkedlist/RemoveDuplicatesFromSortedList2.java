package sujung.linkedlist;

public class RemoveDuplicatesFromSortedList2 {

    private static class ListNode {
        int val;
       ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode deleteDuplicates(ListNode head) {
        ListNode answer = new ListNode();
        ListNode pre = head;
        ListNode post = answer;
        post.next = pre;

        while(pre != null) {
            while (pre.next != null && pre.val == pre.next.val) {
                pre = pre.next;
            }
            if(post.next != pre) {
                post.next = pre.next;
                pre = pre.next;
            } else {
                pre = pre.next;
                post = post.next;
            }
        }
        return answer.next;
    }
}
