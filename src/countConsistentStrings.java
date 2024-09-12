import java.util.HashSet;
import java.util.Set;

public class countConsistentStrings {
    public int countConsistentStrings(String allowed, String[] words) {
        int count=0;
        Set<Character> AllowedSet = new HashSet<>();
        for (int i=0; i<allowed.length();i++){
            AllowedSet.add(allowed.charAt(i));
        }
        for (String word : words) {
            int flag=1;
            for (int i =0; i<word.length();i++){
                if (!AllowedSet.contains(word.charAt(i))){
                    flag=0;
                    break;
                }
            }
            count+=flag;
        }
        return count;
        }

    }

