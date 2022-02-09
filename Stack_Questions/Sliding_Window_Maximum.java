package Stack_Questions;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class Sliding_Window_Maximum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int k = sc.nextInt();
        System.out.println(slideMax(arr, k));
    }
    public static ArrayList<Integer> slideMax(int[] arr, int k) {
        int n = arr.length;
        ArrayList<Integer> list = new ArrayList<>();
        Stack<Integer> st = new Stack<>();
        for (int j = 0; j < n ; j++) {
            if (st.isEmpty()) {
                st.push(arr[j]);
            }
            else{
                if (st.peek() > arr[j]) {
                    int temp = st.pop();
                    st.push(arr[j]);
                    st.push(temp);
                }
                else {
                    st.push(arr[j]);
                }
            }
            if (j + 1 >= k ) {
                list.add(st.peek());
            }
        }
        return list;
    }
}
