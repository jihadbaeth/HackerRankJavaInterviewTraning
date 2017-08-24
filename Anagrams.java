import java.util.ArrayList;
import java.util.Scanner;

public class Anagrams {
    public static int numberNeeded(String first, String second) {
        int numberNeeded = 0;
        ArrayList<Integer> holder = new ArrayList<>();
        StringBuilder firstBuilder = null;
        StringBuilder secondBuilder = null;
        if (first.length() >= second.length()) {
            firstBuilder = new StringBuilder(first);
            secondBuilder = new StringBuilder(second);
        } else {
            firstBuilder = new StringBuilder(second);
            secondBuilder = new StringBuilder(first);
        }


        for (int i = 0; i < first.length(); i++) {

            char charToCompare = first.charAt(i);


            if (firstBuilder.indexOf("" + charToCompare) > -1 && secondBuilder.indexOf("" + charToCompare) > -1) {
                firstBuilder.deleteCharAt(firstBuilder.indexOf("" + charToCompare));
                secondBuilder.deleteCharAt(secondBuilder.indexOf("" + charToCompare));

            } else {
                if (firstBuilder.indexOf("" + charToCompare) > -1) {
                    firstBuilder.deleteCharAt(firstBuilder.indexOf("" + charToCompare));
                    numberNeeded++;
                }

                if (secondBuilder.indexOf("" + charToCompare) > -1) {
                    secondBuilder.deleteCharAt(secondBuilder.indexOf("" + charToCompare));
                    numberNeeded++;
                }
            }

        }
        numberNeeded = numberNeeded + firstBuilder.length() + secondBuilder.length();

        return numberNeeded;

    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String firstArray = in.next();
        String secondArray = in.next();
        System.out.println(numberNeeded(firstArray, secondArray));
    }
}