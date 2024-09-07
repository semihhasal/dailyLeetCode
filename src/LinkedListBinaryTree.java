public class LinkedListBinaryTree {

    public boolean isSubPath(ListNode head, TreeNode root) {

        return dfs(head,head,root);


    }
        public boolean dfs(ListNode head, ListNode current, TreeNode root) {
        if (current == null) return true;//bağlantılı liste sonuna başarıyla ulaştık
        if (root==null) return false;//liste bitmeden sona ulaşırsak

        if (current.val == root.val)current = current.next;  //liste elemanı ağaçtaki elemanla eşleşirse
        else if (head.val == root.val) head = head.next;//liste elemanı ağacın başı ile eşleşirse
        else current=head;

        return dfs(head, current, root.left) || dfs(head, current, root.right);




    }


     public class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
      }


  public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
}
