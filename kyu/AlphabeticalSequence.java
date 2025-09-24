// "ZpglnRxqenU" -> "Eeeee,Ggggggg,Llllllllllll,Nnnnnnnnnnnnnn,Nnnnnnnnnnnnnn,Pppppppppppppppp,Qqqqqqqqqqqqqqqqq,Rrrrrrrrrrrrrrrrrr,Uuuuuuuuuuuuuuuuuuuuu,Xxxxxxxxxxxxxxxxxxxxxxxx,Zzzzzzzzzzzzzzzzzzzzzzzzzz"

import java.util.ArrayList;
import java.util.Arrays;

public class AlphabeticalSequence {
    public static String alphaSeq(String s) {

        String alphabets = "abcdefghijklmnopqrstuvwxyz";
        ArrayList<String> build = new ArrayList<>();
        String temp;
        s = s.toLowerCase();
        String[] inputs = s.split("");
        Arrays.sort(inputs);
        for (int i = 0; i < inputs.length; i++) {
            for (int j = 0; j < (alphabets.indexOf(inputs[i]) + 1); j++) {
                if (j == 0) {
                    temp = inputs[i].toUpperCase();
                    build.add(temp);
                    continue;
                }
                build.add(inputs[i]);
            }
            if (i != inputs.length - 1)
                build.add(",");
        }
        String[] builded = build.toArray(new String[0]);
        s = String.join("", builded);
        return s;
    }

    public static void main(String[] args) {
        System.out.println("\n" + alphaSeq("ZpglnRxqenU"));
    }
}

// in java to access a string you can't just write s[i] you just have to write
// charAt('')
