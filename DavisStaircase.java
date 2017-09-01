import java.util.Scanner;
import java.util.HashMap;


public class DavisStaircase {


//    private static HashMap<Integer, Integer> cache = new HashMap<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int s = sc.nextInt();
//        cache.put(0, 1); // base case

        for (int tc = 0; tc < s; tc++) {
            int n = sc.nextInt();
            System.out.println(numberOfPaths(n, new int[n + 1]));
        }

        sc.close();
    }

    public static int numberOfPaths(int n, int[] cache) {
        if (n < 0) return 0;
        if (n == 0) return 1;
        if (cache[n] == 0) {
            cache[n] = numberOfPaths(n - 1, cache) + numberOfPaths(n - 2, cache) + numberOfPaths(n - 3, cache);
        }
        return cache[n];
    }
    //hashmap memorization based solution from github
//    private static int staircase(int n) {
//        if (n < 0) {
//            return 0;
//        }
//        if (cache.containsKey(n)) {
//            return cache.get(n);
//        }
//        int ways = staircase(n - 1) + staircase(n - 2) + staircase(n - 3);
//        cache.put(n, ways);
//        return ways;
//    }

    //my initial solution which was wrong due to high complexity

//    public static int numberOfPaths(int n){
//        if(n<0) return 0;
//        if(n==0) return 1;
//        return numberOfPaths(n-1) + numberOfPaths(n-2) + numberOfPaths(n-3);
//    }


    //iteration based solution with the best O complexity
//
//    static int solve(int n) {
//        int prevprevprev = 0;5
//        int prevprev = 1;
//        int prev = 1;
//        for (int i = 0; i < n - 1; i++) {
//            int current = prevprevprev + prevprev + prev;
//            prevprevprev = prevprev;
//            prevprev = prev;
//            prev = current;
//        }
//        return prev;
//    }
}
