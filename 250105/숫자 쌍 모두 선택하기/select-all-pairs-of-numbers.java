import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine().trim());
        int[][] meetings = new int[n][2];  // [start, end]
        
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            meetings[i][0] = a;  // start
            meetings[i][1] = b;  // end
        }
        
        Arrays.sort(meetings, (m1, m2) -> Integer.compare(m1[0], m2[0]));
        
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        
        for (int i = 0; i < n; i++) {
            int startTime = meetings[i][0];
            int endTime   = meetings[i][1];
            
            if (!minHeap.isEmpty() && minHeap.peek() <= startTime) {
                minHeap.poll();
            }
            
            minHeap.offer(endTime);
        }
        
        System.out.println(minHeap.size());
    }
}
