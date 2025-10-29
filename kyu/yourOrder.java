import java.util.ArrayList;
import java.util.List;
import java.util.regex.*;

public class yourOrder {
    public static String order(String s) {
        // ...
        ArrayList<String> words = new ArrayList<>(List.of(s.split(" ")));
        Pattern pattern = Pattern.compile("\\d");
        Matcher match;
        String[] result = new String[words.size()];

        for (String word : words) {
            match = pattern.matcher(word);
            if (match.find()) {
                result[Integer.valueOf(match.group(0))-1] = word;
            }

        }
        return String.join(" " ,result);
    }

    public static void main(String[] args) {
        System.out.println(order("is2 Thi1s T4est 3a"));
    }
}
