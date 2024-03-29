import java.util.*;
import java.io.*;

public class Main {
    public static final int MAX_NODE = 100000;
    public static ArrayList<Integer>[] nodeList = new ArrayList[MAX_NODE + 1];
    public static int[] panIn = new int[MAX_NODE + 1];
    public static int[] ans = new int[MAX_NODE + 1];
    public static boolean[] visited = new boolean[MAX_NODE + 1];
    public static PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
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
            nodeList[end].add(start);
            panIn[start]++;
        }

        for(int i = 1 ; i <= n ; i++){
            if(panIn[i] == 0){
                pq.add(i);
            }
        }

        int cnt = n;
        while(!pq.isEmpty()){
            int curIdx = pq.poll();
            ans[curIdx] = cnt--;

            for(int i = 0 ; i < nodeList[curIdx].size() ; i++){
                int postIdx = nodeList[curIdx].get(i);
                panIn[postIdx]--;
                if(panIn[postIdx] == 0){
                    pq.add(postIdx);
                }
            }
        }

        boolean flag = false;
        for(int i = 1 ; i <= n ; i++){
            if(panIn[i] > 0){
                flag = true;
                break;
            }
        }

        StringBuilder sb = new StringBuilder();
        if(flag){
            System.out.print(-1);
        }
        else{
            for(int i = 1 ; i <= n ; i++){
                sb.append(ans[i] + " ");
            }
        }
        bw.write(sb.toString());

        br.close();
        bw.close();
    }
}