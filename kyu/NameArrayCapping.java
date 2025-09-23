// ["jo", "nelson", "jurie"] -->  ["Jo", "Nelson", "Jurie"]
// ["KARLY", "DANIEL", "KELSEY"] --> ["Karly", "Daniel", "Kelsey"]

import java.util.ArrayList;
import java.util.Arrays;

public class NameArrayCapping {
    public static String[] capMe(String[] arr) {
        String firstL, remaining;
        ArrayList<String> res = new ArrayList<>();
        if (arr.length == 0)
            return new String[0];
        for (int i = 0; i < arr.length; i++) {
            firstL = arr[i].split("")[0].toUpperCase();
            remaining = arr[i].substring(1).toLowerCase();
            res.add(firstL + remaining);
        }
        return res.toArray(new String[0]);
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(capMe(new String[] {})));
    }
}
