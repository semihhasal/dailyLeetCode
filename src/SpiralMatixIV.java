import java.util.Arrays;

public class SpiralMatixIV {

//    Input: m = 3, n = 5, head = [3,0,2,6,8,1,7,9,4,2,5,5,0]
//    Output: [[3,0,2,6,8],[5,0,-1,-1,1],[5,2,4,9,7]]
public  void main(String[] args) {
    // Verilen input listesi [3,0,2,6,8,1,7,9,4,2,5,5,0]
    ListNode head = new ListNode(3,
            new ListNode(0,
                    new ListNode(2,
                            new ListNode(6,
                                    new ListNode(8,
                                            new ListNode(1,
                                                    new ListNode(7,
                                                            new ListNode(9,
                                                                    new ListNode(4,
                                                                            new ListNode(2,
                                                                                    new ListNode(5,
                                                                                            new ListNode(5,
                                                                                                    new ListNode(0)))))))))))));

    // Matrisin boyutları m = 3, n = 5
    int m = 3, n = 5;
    int[][] result = spiralMatrix(m, n, head);

    // Çıktıyı yazdırma
    for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
            System.out.print(result[i][j] + " ");
        }
        System.out.println();
    }
}

    public int[][] spiralMatrix(int rows, int columns, ListNode head) {

        int[][] matrix = new int[rows][];
        for (int i = 0; i < rows; i++) {
            matrix[i] = new int [columns];
            Arrays.fill(matrix[i], -1);
        }
        int toprow=0;
        int bottomrow=rows-1;
        int leftcolumm=0;
        int rightcolumns=columns-1;

        while (head!=null){

            for (int col=leftcolumm; col<=rightcolumns && head!=null; col++) {
                matrix[toprow][col] = head.val;
                head=head.next;

            }
            toprow++;
            for (int row=toprow; row<=bottomrow && head!=null; row++) {
                matrix[row][rightcolumns] = head.val;
                head=head.next;

            }
            rightcolumns--;
            for (int col=rightcolumns; col>=leftcolumm && head!=null; col--) {
                matrix[bottomrow][col] = head.val;
                head=head.next;

            }
            bottomrow--;
            for (int row = bottomrow; row >= toprow && head != null; row--) {
                matrix[row][leftcolumm] = head.val;
                head = head.next;
            }
            leftcolumm++;

        }
        return matrix;




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
