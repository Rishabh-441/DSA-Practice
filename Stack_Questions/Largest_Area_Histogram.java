package Stack_Questions;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class Largest_Area_Histogram {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int[] left_grt = leftCount(arr);
        int[] right_gtr = rightCount(arr);

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int area = arr[i] * (1 + left_grt[i] + right_gtr[i]);
            max = Math.max(area, max);
        }
        System.out.println(max);

    }
    public static int[] leftCount(int[] arr) {
        int n = arr.length;
        Stack<Integer> st = new Stack<>();
        int[] ngel = new int[n];

        for (int i = 0; i < n; i++) {
            int num = arr[i];
            while (!st.isEmpty() && num <= arr[st.peek()]) {
                st.pop();
            }
            if (st.isEmpty()) ngel[i] = i;
            else ngel[i] = i - st.peek() - 1;
            st.push(i);
        }
       return ngel;
    }

    public static int[] rightCount (int[] arr) {
        int n = arr.length;

        Stack<Integer> st = new Stack<>();
        int[] nge = new int[n];

        for (int i = n-1; i >= 0; i--) {
            while (st.size() > 0 && arr[i] <= arr[st.peek()]) {
                st.pop();
            }
            if (st.isEmpty()) nge[i] = n - i - 1;
            else nge[i] = st.peek() - i - 1;
            st.push(i);
        }
        return nge;
    }
}
