package Stack_Questions;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class Next_Greater_Element_To_The_Left {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        Stack<Integer> st = new Stack<>();
        int[] ngel = new int[n];
        ngel[0] = -1;

        for (int i = 1; i < n; i++) {
            int num = arr[i];
            while (!st.isEmpty() && num >= st.peek()) {
                st.pop();
            }
            if (st.isEmpty()) {
                ngel[i] = -1;
            }
            else {
                ngel[i] = st.peek();
            }
            st.push(arr[i]);
        }
        System.out.println(Arrays.toString(ngel));
    }
}
