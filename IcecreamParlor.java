import java.util.HashMap;
import java.util.Scanner;

public class IcecreamParlor {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int a0 = 0; a0 < t; a0++) {
            int m = in.nextInt();
            int n = in.nextInt();
            int[] costs = new int[n];
            for (int i = 0; i < n; i++) {
                costs[i] = in.nextInt();
            }
            buyIceCream(costs, m);
        }
        in.close();
    }

    public static void buyIceCream(int[] costs, int money) {
        HashMap<Integer, Integer> map = new HashMap<>(); // key = cost, value = ice cream ID
        for (int i = 0; i < costs.length; i++) {
            int icecreamID = i + 1;
            int cost = costs[i];

            /* Find 2 flavors to buy that sum to "money" */
            int otherCost = money - cost;
            if (map.containsKey(otherCost)) {
                System.out.println(map.get(otherCost) + " " + icecreamID);
            }

            map.putIfAbsent(cost, icecreamID);
        }
    }
}
