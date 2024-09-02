//Input: chalk = [5,1,5], k = 22
//Output: 0
//Explanation: The students go in turns as follows:
//        - Student number 0 uses 5 chalk, so k = 17.
//        - Student number 1 uses 1 chalk, so k = 16.
//        - Student number 2 uses 5 chalk, so k = 11.
//        - Student number 0 uses 5 chalk, so k = 6.
//        - Student number 1 uses 1 chalk, so k = 5.
//        - Student number 2 uses 5 chalk, so k = 0.
//Student number 0 does not have enough chalk, so they will have to replace it.

public class ChalkStudents {

    public int chalkReplacer1(int[] chalk, int k) {

        int studentNumber=0;
        for(int i =0; i<chalk.length; i++){
            if (k>=chalk[i])
            k-=chalk[i];
            else{
               studentNumber=i;
                break;
            }
            if (i+1==chalk.length)
                i=-1;

        }
        return studentNumber;
    }

    //çözüm iki tüm clalk dizisini kya bölerek dngü tekrarını engelleyebiliriz.
    public int chalkReplacer2(int[] chalk, int k) {
        // İlk olarak tüm tebeşir miktarlarının toplamını hesaplayalım
        long totalChalk = 0;
        for (int c : chalk) {
            totalChalk += c;
        }

        // Eğer k toplam tebeşir miktarından büyükse, modunu alıyoruz
        k %= (int) totalChalk;

        // Sonrasında k'dan düşerek hangi öğrencinin tebeşir değiştirmesi gerektiğini buluyoruz
        for (int i = 0; i < chalk.length; i++) {
            if (k < chalk[i]) {
                return i;
            }
            k -= chalk[i];
        }

        // Bu noktaya gelinmemesi lazım çünkü bir öğrenci her zaman tebeşir değiştirmek zorunda
        return -1;
    }
    public void main(String[] args) {
        ChalkStudents cs = new ChalkStudents();

        int[] chalk = {5,1,5};
        int k = 22;

        int result = cs.chalkReplacer1(chalk, k);
        int result2 = cs.chalkReplacer2(chalk, k);

        // Beklenen çıkış: 0
        System.out.println("Beklenen sonuç: 0, Hesaplanan sonuç: " + result);
    }
}
