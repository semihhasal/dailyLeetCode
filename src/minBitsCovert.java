import java.util.ArrayList;
import java.util.List;

public class minBitsCovert {
    public int minBitFlips(int start, int goal) {

        List startList =new ArrayList();
        List goalList =new ArrayList();

        while (start>0 ||goal>0){
            startList.add(start%2);
            start/=2;
            goalList.add(goal%2);
            goal/=2;

        }
        int count=0;
        for (int i =0; i<goalList.size(); i++){
            if (!goalList.get(i).equals(startList.get(i))){
                count++;
            }
        }
        return count;
    }
}
