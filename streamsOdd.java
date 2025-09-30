import java.util.*;
import java.util.stream.*;

public class streamsOdd {
    public static String oddOrEven(int[] array) {
        int res = Arrays.stream(array).reduce((tot,acc) -> tot + acc).orElse(0);
        if(res % 2 == 0) return "even";
        else return "odd";
    }

    public static void main(String[] args) {
        oddOrEven(new int[] { 2, 5, 34, 6 });
    }
}
