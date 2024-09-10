public class insertGreatestCommonDivisors {

    public ListNode insertGreatestCommonDivisors(ListNode head) {

        ListNode current=head;

        while (current.next != null) {
            int ebob= ebob(current.val,current.next.val);
            ListNode ebobNode= new ListNode(ebob);

            ebobNode.next=current.next;
            current.next=ebobNode;

            current = ebobNode.next;
        }
        return head;

    }
    public void main(String[] args) {
        // Örnek linked list: [18, 6, 10, 3]
        ListNode head = new ListNode(18,
                new ListNode(6,
                        new ListNode(10,
                                new ListNode(3))));

        // Listeyi işleyen fonksiyonu çağır
        ListNode result = insertGreatestCommonDivisors(head);
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
    }
    public int ebob(int a, int b) {
        if (b == 0) {
            return a;
        }
        return ebob(b, a % b);
    }
    public class ListNode {
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

}
