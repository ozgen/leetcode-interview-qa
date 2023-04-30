import java.util.Stack;

public class ValidParenthesis {
    /**
     * https://leetcode.com/problems/valid-parentheses/
     */
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()){

            if(c == '('){
                stack.push(')');
            } else if (c == '[') {
                stack.push(']');
            } else if (c =='{') {
                stack.push('}');
            }else if(stack.empty() || stack.pop() != c){
                return false;
            }
        }
        return stack.empty();
    }
}
