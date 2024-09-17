import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class uncommonFromSentences {
    public String[] uncommonFromSentences(String s1, String s2) {

        String[] a1=s1.split(" ");
        String[] a2=s2.split(" ");
        List<String> result=new ArrayList<>();

        Map<String, Integer> wordCount = new HashMap<>();
        for (String word : a1) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }

        for (String word : a2) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }

        for (Map.Entry<String, Integer> entry : wordCount.entrySet()) {
            if (entry.getValue() == 1) {

                result.add(entry.getKey());
            }
        }

return result.toArray(new String[0]);
    }
}
