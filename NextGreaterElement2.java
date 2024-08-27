import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElement2 {
    public static int[] nextGreaterElements(int[] nums) { //O(4*n) T.C
        Stack<Integer> st = new Stack<>(); //O(n) S.C, monotonic stack
        int n = nums.length;
        int[] res = new int[n];
        Arrays.fill(res, -1); //as default value for non-answer is -1
        for(int i=0; i<2*n; i++) { //going over the input twice as it is circular array
            int index = i%n; //taking index as only 1..n
            while(!st.isEmpty() && nums[index] > nums[st.peek()]) { //while current value is greater than stacked
                int popped = st.pop(); //process the stacked values
                res[popped] = nums[index]; //put the next greater value in the current value's index
            }
            if(i < n) st.push(i); //only push into stack in the initial traversal
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums = {4, 17, 5, 11, 78, 35, 22, 3, 9};

        System.out.println("The next largest number to each individual value in the circular array " +
                Arrays.toString(nums) + " is: " + Arrays.toString(nextGreaterElements(nums)));
    }
}
