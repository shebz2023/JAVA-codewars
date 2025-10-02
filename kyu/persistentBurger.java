import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class persistentBurger {
    public static int persistence(long n) {
        String number = Long.toString(n);
        ArrayList<String> nArray = new ArrayList<>(List.of(number.split("")));
        int prod = 1, count = 0, currInt;
        while (nArray.size() > 1) {
            for (String curr : nArray) {
                currInt = Integer.valueOf(curr);
                prod *= currInt;
            }
            nArray.clear();
            nArray.addAll(Arrays.asList(String.valueOf(prod).split("")));
            prod = 1;
            count++;

        }
        return count;

    }

    public static void main(String[] args) {
        System.out.println(persistence(39));
    }
}
