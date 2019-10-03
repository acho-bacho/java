package hackerrank.CrackingTheCodingInterview.Stacks;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Stack;

public class BalancedBrackets {

    // ArrayDeque is "likely to be faster than Stack when used as a stack" - Java documentation

//  Time Complexity: O(n)
// Space Complexity: O(n)

    /* Create HashMap to match opening brackets with closing brackets */
    static String isBalanced(String expression) {
        HashMap<Character, Character> map = new HashMap<>();
        //keys are opening brackets, values are closing brackets
        map.put('(', ')');
        map.put('[', ']');
        map.put('{', '}');
        return isBalanced(expression, map) ? "YES" : "NO";
    }

    private static boolean isBalanced(String expression, HashMap<Character, Character> map) {
        if ((expression.length() % 2) != 0) {
            return false; // odd length Strings are not balanced
        }
        ArrayDeque<Character> stack = new ArrayDeque<>(); // use deque as a stack
        for (int i = 0; i < expression.length(); i++) {
            Character ch = expression.charAt(i);

            //if opening bracket i.e.
            if (map.containsKey(ch)) {
                //put it in the stack
                stack.push(ch);
                // else pop and check that it's a closing bracket corresponding to the opening
            } else if (stack.isEmpty() || ch != map.get(stack.pop())) {
                return false;
            }
        }
        return stack.isEmpty();
    }

    public static boolean isBalanced2(String expression) {
        Stack<Character> s = new Stack<>();

        for (char c : expression.toCharArray()) {
            switch (c) {
                case '(':
                    s.push(')');
                    break;
                case '[':
                    s.push(']');
                    break;
                case '{':
                    s.push('}');
                    break;
                default:
                    if (s.empty() || s.pop() != c) return false;
            }
        }
        return s.empty();
    }

    public static void main(String[] args) {

    }
}
