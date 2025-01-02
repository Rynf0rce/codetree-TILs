import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int[] heights = new int[n];
        for (int i = 0; i < n; i++) {
            heights[i] = Integer.parseInt(st.nextToken());
        }
        
        int[] answer = new int[n];
        
        Stack<int[]> stack = new Stack<>();
        
        for (int i = 0; i < n; i++) {
            int currentHeight = heights[i];
            
            while (!stack.isEmpty() && stack.peek()[1] <= currentHeight) {
                stack.pop();
            }
            
            if (stack.isEmpty()) {
                answer[i] = 0;
            } else {
                answer[i] = stack.peek()[0];
            }
            
            stack.push(new int[]{i+1, currentHeight});
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(answer[i]).append(" ");
        }
        
        System.out.println(sb.toString().trim());
    }
}
