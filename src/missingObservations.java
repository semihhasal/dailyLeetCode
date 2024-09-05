import java.util.Arrays;

//Input: rolls = [3,2,4,3], mean = 4, n = 2
//Output: [6,6]
//Explanation: The mean of all n + m rolls is (3 + 2 + 4 + 3 + 6 + 6) / 6 = 4.
public class missingObservations {

    public static void main(String[] args) {


        missingObservations missingRolls = new missingObservations();

        int[] rolls = {3, 2, 4, 3};
        int mean = 4;
        int n = 2;

        System.out.println(Arrays.toString(missingRolls.missingRolls(rolls, mean, n))); // Sonucu yazdır


    }
    //solution1
    public int[] missingRolls(int[] rolls, int mean, int n) {

        int TotalScore=(rolls.length+n)*mean;
        int[] missingDices =new int[n];
        int remains=0;
        for (int i = 0; i < rolls.length; i++) {
            TotalScore-=rolls[i];
        }
        if (TotalScore%n==0){
            for (int i =0; i< missingDices.length; i++) {
                missingDices[i]=TotalScore/n;
            }
        }
        if (TotalScore> 6*missingDices.length || TotalScore<0 || TotalScore<missingDices.length){
            return  new int[0];
        }
        remains=TotalScore%n;
        TotalScore=TotalScore-remains;
        for (int i =0; i< missingDices.length; i++) {
            missingDices[i]=TotalScore/n;
        }
        for (int i =0; i< remains; i++) {
            missingDices[i]+=1;
        }


    return missingDices;
    }

    //solution2
    public int[] missingRolls2(int[] rolls, int mean, int n) {
        int m = rolls.length;
        int totalSum = mean * (n + m);
        int observedSum = 0;

        for (int roll : rolls) {
            observedSum += roll;
        }

        int missingSum = totalSum - observedSum;

        if (missingSum < n || missingSum > 6 * n) {
            return new int[0];
        }

        int base = missingSum / n;
        int remainder = missingSum % n;

        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            result[i] = base + (i < remainder ? 1 : 0);
        }

        return result;
    }


}
