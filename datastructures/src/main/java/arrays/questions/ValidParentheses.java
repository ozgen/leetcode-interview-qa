package arrays.questions;

import java.util.Stack;

/**
 * https://leetcode.com/problems/valid-parentheses/
 */

public class ValidParentheses {

    public boolean isValid(String s) {
        if (s.length() % 2 != 0) {
            return false;
        }
        Stack<Character> stack = new Stack();
        for (Character c : s.toCharArray()) {
            if (stack.empty() && (c == ')' || c == ']' || c == '}')) {
                return false;
            } else {
                if (!stack.isEmpty()) {
                    if (
                            stack.peek() == '(' && c == ')'
                    ) stack.pop();
                    else if (
                            stack.peek() == '{' && c == '}'
                    ) stack.pop();
                    else if (
                            stack.peek() == '[' && c == ']'
                    ) stack.pop();
                    else stack.add(c);
                } else stack.add(c);
            }
        }
        return stack.empty();
    }

    public boolean isValid2(String s) {
        Stack<Character> stack = new Stack<Character>();
        for (char c : s.toCharArray()) {
            if (c == '(')
                stack.push(')');
            else if (c == '{')
                stack.push('}');
            else if (c == '[')
                stack.push(']');
            else if (stack.isEmpty() || stack.pop() != c)
                return false;
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        ValidParentheses validParentheses = new ValidParentheses();
        String s = "{[]}";
        boolean valid = validParentheses.isValid(s);
        System.out.println(valid);
    }
}
