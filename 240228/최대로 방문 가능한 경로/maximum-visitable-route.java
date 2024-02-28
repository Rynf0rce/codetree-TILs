import java.util.*;
import java.io.*;

public class Main {
    public static final int MAX_NODE = 100000;
    public static ArrayList<Integer>[] nodeList = new ArrayList[MAX_NODE + 1];
    public static int[] inDegree = new int[MAX_NODE + 1];
    public static int[] DP = new int[MAX_NODE + 1];
    public static int[] connect = new int[MAX_NODE + 1];
    public static PriorityQueue<Integer> pq = new PriorityQueue<>();
    public static ArrayList<Integer> ansList = new ArrayList<>();

    public static void topological(){
        while(!pq.isEmpty()){
            int curIdx = pq.poll();
            for(int i = 0 ; i < nodeList[curIdx].size() ; i++){
                int postIdx = nodeList[curIdx].get(i);

                inDegree[postIdx]--;
                if(inDegree[postIdx] == 0){
                    pq.add(postIdx);
                }
            }
        }
    }

    public static void findAns(){
        while(!pq.isEmpty()){
            int curIdx = pq.poll();
            for(int i = 0 ; i < nodeList[curIdx].size() ; i++){
                int postIdx = nodeList[curIdx].get(i);

                inDegree[postIdx]--;
                if(inDegree[postIdx] == 0){
                    pq.add(postIdx);
                }

                if(DP[postIdx] < DP[curIdx] + 1){
                    DP[postIdx] = DP[curIdx] + 1;
                    connect[postIdx] = curIdx;                 
                }
                else if(DP[postIdx] == DP[curIdx] + 1){
                    connect[postIdx] = Math.min(connect[postIdx], curIdx);
                }
            }
        }
    }

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
            inDegree[start]++;
        }

        for(int i = 1 ; i < n ; i++){
            if(inDegree[i] == 0){
                pq.add(i);
                DP[i] = 1;
            }
        }

        topological();

        pq.add(n);
        DP[n] = 1;
        findAns();

        int idx = 1;
        boolean flag = true;
        while(true){
            ansList.add(idx);
            idx = connect[idx];
            if(idx == n){
                flag = false;
            }

            if(idx == 0){
                break;
            }
        }

        StringBuilder sb = new StringBuilder();
        if(flag){
            sb.append(-1);
        }
        else{
            sb.append(ansList.size() + "\n");
            for(int i = 0 ; i < ansList.size() ; i++){
                sb.append(ansList.get(i) + " ");
            }
        }

        bw.write(sb.toString());
        
        br.close();
        bw.close();
    }
}