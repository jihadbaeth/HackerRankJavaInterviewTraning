import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class PrimeChecker {

    public static boolean isPrime(int testNumber) {
        boolean isPrime = true;
        if (testNumber == 0) {
            return false;
        }
        if (testNumber == 1) {
            return false;
        }
        if (testNumber == 2) {
            return true;
        } else {
            for (int x = 2; x <= testNumber / 2; x++) {
                if (testNumber % x == 0) return false;
            }
        }
        return isPrime;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int p = in.nextInt();
        for (int a0 = 0; a0 < p; a0++) {
            int n = in.nextInt();
            if (isPrime(n)) {
                System.out.println("Prime");
            } else {
                System.out.println("Not prime");
            }
        }
    }
}
