package Stack_Questions;

/*
-,a,+
pop --> smaller elements
stop and push --> when top is greater than the element
print -1 --> if stack is empty
 */


import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class NextGreaterElementToTheRight {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        Stack<Integer> st = new Stack<>();
        int[] nge = new int[n];
        nge[n-1] = -1;
        st.push(arr[n-1]);

        for (int i = n-2; i >= 0; i--) {
            while (st.size() > 0 && arr[i] >= st.peek()) {
                st.pop();
            }
            if (st.size() == 0) {
                nge[i] = -1;
            }
            else{
                nge[i] = st.peek();
            }
            st.push(arr[i]);
        }
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(nge));
    }
}
