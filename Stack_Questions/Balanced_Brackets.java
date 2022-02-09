package Stack_Questions;

import java.util.Scanner;
import java.util.Stack;

public class Balanced_Brackets {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        Stack<Character> st = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == '(' || ch == '[' || ch == '{') {
                st.push(ch);
            }
            else if (ch == ')'){
                boolean val = handleClosing(st, '(');
                if (!val) {
                    System.out.println(val);
                    return;
                }
            }
            else if (ch == ']') {
                boolean val = handleClosing(st, '[');
                if (!val) {
                    System.out.println(val);
                    return;
                }
            }
            else if (ch == '}') {
                boolean val = handleClosing(st, '{');
                if (!val) {
                    System.out.println(val);
                    return;
                }
            }
        }
        if (!st.isEmpty()) {
            System.out.println(false);
            return;
        }
        System.out.println(true);
    }

    private static boolean handleClosing(Stack<Character> st, char ch) {
        if (st.size() == 0) {
            return false;
        }
        if (st.peek() != ch) {
            return false;
        }
        else {
            st.pop();
        }
        return true;
    }
}



