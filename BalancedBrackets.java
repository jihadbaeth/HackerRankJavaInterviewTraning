import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class BalancedBrackets {

    public static boolean isBalanced(String expression) {

        Stack<String> stack = new Stack<String>();
        boolean isBalanaced = false;

        for (int i = 0; i < expression.length(); i++) {
            String str = "" + expression.charAt(i);        //store characters as String

            //if opening bracket then push into stack
            if (str.equals("(") || str.equals("[") || str.equals("{")) {
                stack.push(str);
            }

            //if closing bracket, pop bracket and compare if its a pair
            if (str.equals(")") || str.equals("]") || str.equals("}")) {
                //if stack becomes empty in between then also its not balanced
                if (stack.isEmpty()) {
                    return false;
                }
                String opening = stack.peek();
                if (str.equals(")") && opening.equals("(")) {
                    stack.pop();
                }
                if (str.equals("]") && opening.equals("[")) {
                    stack.pop();
                }
                if (str.equals("}") && opening.equals("{")) {
                    stack.pop();
                }
            }
        }
        //if stack is empty at end, then its balanced
        if (expression.length() > 0 && stack.isEmpty()) {
            isBalanaced = true;
        }

        return isBalanaced;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int a0 = 0; a0 < t; a0++) {
            String expression = in.next();
            System.out.println((isBalanced(expression)) ? "YES" : "NO");
        }
    }
}
