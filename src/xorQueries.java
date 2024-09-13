public class xorQueries {
    public int[] xorQueries(int[] arr, int[][] queries) {

        int[] result=new int[queries.length];

        for (int i=0; i< queries.length;i++){
           int temp1=queries[i][0];
           int temp2=queries[i][1];
           int resultInt=arr[temp1];
           for (int j=temp1+1; j<=temp2; j++){
               resultInt^=arr[j];
           }
           result[i]=resultInt;

        }
     return result;
    }
}
