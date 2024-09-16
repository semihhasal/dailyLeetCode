import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class findMinDifference {
    public int findMinDifference(List<String> timePoints) {
        List<Integer>minutesList=new ArrayList<>();

        for (String time: timePoints){
            String[] parts= time.split(":");
            int hours=Integer.parseInt(parts[0]);
            int minutes=Integer.parseInt(parts[1]);

            minutesList.add(hours*60+minutes);

        }
        Collections.sort(minutesList);

        int minDifferance=Integer.MAX_VALUE;

        for (int i=1; i<minutesList.size(); i++){
            int diff=minutesList.get(i) - minutesList.get(i-1);
            minDifferance=Math.min(minDifferance,diff);
        }

        //check wrap world
        int wrap=1440-(minutesList.get(minutesList.size()-1)-minutesList.get(0));
        minDifferance=Math.min(minDifferance,wrap);

        return minDifferance;
    }
}
