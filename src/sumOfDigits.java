//input: s = "iiii", k = 1
//Output: 36
//Explanation: The operations are as follows:
//        - Convert: "iiii" ➝ "(9)(9)(9)(9)" ➝ "9999" ➝ 9999
//        - Transform #1: 9999 ➝ 9 + 9 + 9 + 9 ➝ 36
//Thus the resulting integer is 36.
//Example 2:
//
//Input: s = "leetcode", k = 2
//Output: 6
//Explanation: The operations are as follows:
//        - Convert: "leetcode" ➝ "(12)(5)(5)(20)(3)(15)(4)(5)" ➝ "12552031545" ➝ 12552031545
//        - Transform #1: 12552031545 ➝ 1 + 2 + 5 + 5 + 2 + 0 + 3 + 1 + 5 + 4 + 5 ➝ 33
//        - Transform #2: 33 ➝ 3 + 3 ➝ 6
//Thus the resulting integer is 6.
//Example 3:
//
//Input: s = "zbax", k = 2
//Output: 8

public class sumOfDigits {
    public int getLucky(String s, int k) {

        int total = 0;
        int num=0;

        // İlk harflerden toplamı hesapla
        for (int i = 0; i < s.length(); i++) {
            num += s.charAt(i) - 'a' + 1;
            while(num>9) {
                total += num % 10;
                num /= 10;
            }
                total += num;
                num = 0;

        }


        // k kez dönüştürme işlemi yap
        for (int i = 1; i < k; i++) {
            int newTotal = 0;
            while (total > 0) {
                newTotal += total % 10;
                total /= 10;
            }
            total = newTotal;
        }

        return total;
    }

    public void main(String[] args) {
        String s = "leetcode";
        int k = 2;

        int result = getLucky(s, k);

        // Beklenen sonuç: 6
        System.out.println("Output: " + result); // Output: 6
    }
}
