public class longestSubarray {
    public int longestSubarray(int[] nums) {

        int max=0;
        for (int i=0;i<nums.length;i++){
           if (nums[i]>max){
               max=nums[i];
            }
        }
        int longestsubarray=0;
        int maxLongestArray=0;
        for (int i=0;i<nums.length;i++){
            if (nums[i]==max){
                longestsubarray++;
                maxLongestArray=Math.max(maxLongestArray,longestsubarray);
            }
            else{
                longestsubarray=0;
            }
        }
        return maxLongestArray;
    }
    public static void main(String[] args) {
        longestSubarray solution = new longestSubarray();
        int[] nums = {1, 2, 3, 3, 2, 2};
        System.out.println("En uzun alt dizi uzunluğu: " + solution.longestSubarray(nums));
    }
}
