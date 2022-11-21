package linklists.questions;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfStudentsUnableToEatLunch {
    /**
     * https://leetcode.com/problems/number-of-students-unable-to-eat-lunch/
     */

    public int countStudents(int[] students, int[] sandwiches) {
        Queue<Integer> studentQueue = new LinkedList<>();
        for (int student : students) {
            studentQueue.offer(student);
        }
        Queue<Integer> sandwichQueue = new LinkedList<>();
        for (int s : sandwiches) {
            sandwichQueue.offer(s);
        }
        int count = 0;
        while (count != studentQueue.size() && !studentQueue.isEmpty()) {
            if (studentQueue.peek() == sandwichQueue.peek()) {
                count = 0;
                studentQueue.remove();
                sandwichQueue.remove();
            } else {
                studentQueue.offer(studentQueue.remove());
                count++;
            }
        }
        return studentQueue.size();
    }


    public static void main(String[] args) {
        NumberOfStudentsUnableToEatLunch eatLunch = new NumberOfStudentsUnableToEatLunch();
        int[] students = new int[]{1, 1, 1, 0, 0, 1};
        int[] sandwiches = new int[]{1, 0, 0, 0, 1, 1};

        int res = eatLunch.countStudents(students, sandwiches);
        System.out.println(res);
    }
}
