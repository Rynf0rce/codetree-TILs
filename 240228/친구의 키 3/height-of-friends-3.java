import java.util.*;
import java.io.*;

public class Main {
    public static final int MAX_NODE = 100000;
    public static ArrayList<Integer>[] nodeList = new ArrayList[MAX_NODE + 1];
    public static int[] panIn = new int[MAX_NODE + 1];
    public static PriorityQueue<Integer> pq = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        for(int i = 1 ; i <= n ; i++){
            nodeList[i] = new ArrayList<>();
        }
        
        for(int i = 0 ; i < m ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            nodeList[start].add(end);
            panIn[end]++;
        }

        for(int i = 1 ; i <= n ; i++){
            if(panIn[i] == 0){
                pq.add(i);
            }
        }

        StringBuilder sb = new StringBuilder();
        int cnt = 0;
        while(!pq.isEmpty()){
            int curIdx = pq.poll();

            sb.append(curIdx + " ");
            cnt++;
            
            for(int i = 0 ; i < nodeList[curIdx].size() ; i++){
                int postIdx = nodeList[curIdx].get(i);
                panIn[postIdx]--;
                if(panIn[postIdx] == 0){
                    pq.add(postIdx);
                }
            }
        }

        System.out.print(cnt == n ? sb.toString() : -1);
    }
}