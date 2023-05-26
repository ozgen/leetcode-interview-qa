package arrays.questions.stack;


import java.util.Stack;

public class BaseballGame {

    /**
     * https://leetcode.com/problems/baseball-game/
     */
    public int calPoints(String[] ops) {
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < ops.length; i++) {
            if (ops[i].equals("C")) {
                stack.pop();
            } else if (ops[i].equals("D")) {
                stack.push(2 * stack.peek());
            } else if (ops[i].equals("+")) {
                int a = stack.pop();
                int res = a + stack.peek();
                stack.push(a);
                stack.push(res);
            } else stack.push(Integer.valueOf(ops[i]));
        }

        int res = 0;

        while (!stack.isEmpty()) {
            res += stack.pop();
        }

        return res;
    }

    public static void main(String[] args) {
        BaseballGame game = new BaseballGame();
        String[] scores = new String[]{"5", "-2", "4", "C", "D", "9", "+", "+"};
        int res = game.calPoints(scores);
        System.out.println(res);
    }
}
