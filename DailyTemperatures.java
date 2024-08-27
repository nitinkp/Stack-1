import java.util.Arrays;
import java.util.Stack;

public class DailyTemperatures {
    public static int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> st = new Stack<>(); //O(n) S.C, monotonic stack implementation
        int n = temperatures.length;
        int[] res = new int[n];
        for(int i=0; i<n; i++) { //O(2n) T.C, traverse the input
            //while the next traversed input is greater than values in stack
            while(!st.isEmpty() && temperatures[i] > temperatures[st.peek()]) {
                int popped = st.pop(); //process the stacked elements
                res[popped] = i-popped;
            }
            st.push(i); //push the current element into stack for future processing
        }
        return res;
    }

    public static void main(String[] args) {
        int[] temperatures = {69, 68, 72, 70, 71, 78, 75};
        System.out.println("The next warmer day for each individual day in " + Arrays.toString(temperatures)
                        + " is: " + Arrays.toString(dailyTemperatures(temperatures)) + " days ahead");
    }
}
