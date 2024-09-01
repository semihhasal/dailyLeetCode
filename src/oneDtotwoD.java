//Input: original = [1,2,3,4], m = 2, n = 2
//Output: [[1,2],[3,4]]

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


//solution1
public class oneDtotwoD {
    public int[][] construct2DArray(int[] original, int m, int n) {

        int result[][]=new int[m][n];

        int row=0;
        List<Integer> temp= new ArrayList<>();

        for (int i=0; i< original.length;i++){

            temp.add(original[i]);

            if(temp.size()==n){
                for (int j=0; j<n;j++){
                    result[row][j]=temp.get(j);
                }
                row++;
                temp.clear();


            }
        }
        return result;
    }



    //solution2
    public int[][] construct2DArray2(int[] original, int m, int n) {
        if (original.length != m * n) {
            return new int[0][0]; // Eğer m * n, original dizisinin eleman sayısına eşit değilse, boş dizi döndür
        }

        int[][] result = new int[m][n];

        for (int i = 0; i < original.length; i++) {
            // Satır için: i / n, Sütun için: i % n
            result[i / n][i % n] = original[i];
        }

        return result;
    }

    public  void main(String[] args) {
        int[] original = {1, 2, 3, 4};
        int m = 2;
        int n = 2;

        int[][] result = construct2DArray(original, m, n);

        // Sonucu ekrana yazdır
        System.out.println(Arrays.deepToString(result));
    }

}
