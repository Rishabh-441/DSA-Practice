package Stack_Questions;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class Stock_Span {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        Stack<Integer> st = new Stack<>();
        int[] span = new int[n];

        for (int i = 0; i < n; i++) {
            System.out.println("Stack is " + st);
            int num = arr[i];
            while (!st.isEmpty() && num >= arr[st.peek()]) {
                st.pop();
            }
            if (st.isEmpty()) {
                span[i] = i + 1;
            }
            else{
                span[i] = i - st.peek();
            }
            st.push(i);
        }
        System.out.println(Arrays.toString(span));
    }
}
