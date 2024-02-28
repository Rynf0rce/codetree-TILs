import java.util.*;
import java.io.*;

class node{
    int idx, weight;
    public node(int idx, int weight){
        this.idx = idx;
        this.weight = weight;
    }
}

public class Main {
    public static final int MAX_NODE = 100;
    public static ArrayList<node>[] nodeList = new ArrayList[MAX_NODE + 1];
    public static int[] inDegree = new int[MAX_NODE + 1];
    public static int[][] DP = new int[MAX_NODE + 1][MAX_NODE + 1];
    public static Queue<Integer> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
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
            int end = Integer.parseInt(st.nextToken());
            int start = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            nodeList[start].add(new node(end, weight));
            inDegree[end]++;
        }

        for(int i = 1 ; i <= n ; i++){
            if(inDegree[i] == 0){
                q.add(i);
                DP[i][i] = 1;
            }
        }

        while(!q.isEmpty()){
            int curIdx = q.poll();

            for(int i = 0 ; i < nodeList[curIdx].size() ; i++){
                node postNode = nodeList[curIdx].get(i);
                inDegree[postNode.idx]--;
                if(inDegree[postNode.idx] == 0){
                    q.add(postNode.idx);
                }

                for(int j = 1 ; j <= n ; j++){
                    DP[postNode.idx][j] += DP[curIdx][j] * postNode.weight;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 1 ; i <= n ; i++){
            if(DP[n][i] > 0){
                sb.append(i + " " + DP[n][i] + "\n");
            }
        }

        bw.write(sb.toString());
        
        br.close();
        bw.close();
    }
}