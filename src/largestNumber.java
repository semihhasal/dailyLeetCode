import java.util.Arrays;
import java.util.Comparator;

public class largestNumber {
    public static void main(String[] args) {
        largestNumber solution = new largestNumber();
        int[] nums1 = {10, 2};
        System.out.println(solution.largestNumber(nums1)); // "210"

        int[] nums2 = {3, 30, 34, 5, 9};
        System.out.println(solution.largestNumber(nums2)); // "9534330"
    }

    public String largestNumber(int[] nums) {

        String[] strNums=new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strNums[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(strNums, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String order1=o1+o2;
                String order2=o2+o1;
                return order2.compareTo(order1);
            }
        });
        if (strNums[0].equals("0")) {
            return "0";
        }
        StringBuilder largestNumber = new StringBuilder();

        for (String num:strNums){

            largestNumber.append(num);
        }
return largestNumber.toString();
    }
}
