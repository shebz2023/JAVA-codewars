/*You will be given a certain array of length n, such that n > 4, having positive and negative integers but there will be no zeroes and all the elements will occur once in it.

We may obtain an amount of n sub-arrays of length n - 1, removing one element at a time (from left to right).

For each subarray, let's calculate the product and sum of its elements with the corresponding absolute value of the quotient, q = SubProduct/SubSum (if it is possible, SubSum cannot be 0). Then we select the array with the lowest value of |q|(absolute value)

e.g.: we have the array, arr = [1, 23, 2, -8, 5]

Sub Arrays            SubSum    SubProduct         |q|
[23, 2, -8, 5]         22         -1840         83.636363
[1, 2, -8, 5]           0           -80          No value
[1, 23, -8, 5]         21          -920         43.809524
[1, 23, 2, 5]          31           230          7.419355  <--- selected array
[1, 23, 2, -8]         18          -368         20.444444 */

import java.util.*;

public class rmvFromArray {
    public static int[][] selectSubarray(final int[] arr) {
        ArrayList<List<Integer>> subs = new ArrayList<>();
        Map<Integer, List<Integer>> qArray = new HashMap<>();
        int product, sum, quotient, minimum = Integer.MAX_VALUE, temp;

        for (int i : arr) {
            subs.add(Arrays.stream(arr).filter(n -> n != i).boxed().toList());
        }
        for (List<Integer> i : subs) {
            sum = i.stream().mapToInt(n -> n).sum();
            product = i.stream().reduce(1, (prod, acc) -> prod * acc);
            quotient = sum > 0 ? (product / sum) < 0 ? product / sum * -1 : product / sum : -1;
            qArray.put(quotient, i);
        }
        for (Map.Entry<Integer, List<Integer>> i : qArray.entrySet()) {
            temp = i.getKey();
            if (temp > -1) {
                minimum = minimum < temp ? minimum : temp;
            }
        }
        List<Integer> minimumArr = qArray.get(minimum);
        for (int i = 0; i < arr.length; i++) {
            if (!minimumArr.contains(arr[i])) {
                return new int[][] { { i, arr[i] } };
            }
        }
        return new int[][] {};

    }

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(selectSubarray(new int[] { 1, 23, 2, -8, 5 })));
    }
}