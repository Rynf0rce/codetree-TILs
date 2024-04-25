import java.util.*;
import java.io.*;

public class Main {
    public static HashMap<Integer, Integer> lineMap = new HashMap<>();
    public static HashSet<Integer> removeMap = new HashSet<>();
    public static PriorityQueue<Integer> leftPQ = new PriorityQueue<>(Collections.reverseOrder());
    public static PriorityQueue<Integer> rightPQ = new PriorityQueue<>(Collections.reverseOrder());
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        for(int i = 0 ; i < N ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int x1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            leftPQ.add(x1);
            rightPQ.add(x2);
            lineMap.put(x2, x1);
        }

        int ans = 0;
        while(!rightPQ.isEmpty()){
            int curRight = rightPQ.poll();
            int target = lineMap.get(curRight);

            if(removeMap.contains(target)){
                continue;
            }

            boolean flag = true;
            while(!leftPQ.isEmpty()){
                int curLeft = leftPQ.poll();
                if(target == curLeft){
                    if(flag){
                        ans++;
                    }
                    break;
                }

                removeMap.add(curLeft);
                flag = false;
            }
        }

        System.out.print(ans);
        
    }
}