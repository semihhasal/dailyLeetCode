import java.util.HashMap;
import java.util.Map;

public class findTheLongestSubstring {
    public int findTheLongestSubstring(String s) {

        Map<Character,Integer> vovel=new HashMap<>();

        vovel.put('a',1);
        vovel.put('e',2);
        vovel.put('i',4);
        vovel.put('o',8);
        vovel.put('u',16);

        int mask=0;
        HashMap<Integer, Integer> lastOccurred = new HashMap<>();
        lastOccurred.put(0, -1);

        int maxLenght=0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (vovel.containsKey(c)) {
                mask ^= vovel.get(c);

            }
            if (lastOccurred.containsKey(mask)) {
                maxLenght = Math.max(maxLenght, i - lastOccurred.get(mask));
            }
            else
                lastOccurred.put(mask,i);
        }
return maxLenght;
    }
}
