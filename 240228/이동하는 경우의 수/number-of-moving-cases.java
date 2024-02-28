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
    public static final int MAX_NODE = 100000;
    public static ArrayList<node>[] nodeList = new ArrayList[MAX_NODE + 1];
    public static int[] inDegree = new int[MAX_NODE + 1];
    public static int[] disDP = new int[MAX_NODE + 1];
    public static int[] cntDP = new int[MAX_NODE + 1];
    public static Queue<Integer> q = new LinkedList<>();

    public static void main(String[] args) throws IOException{
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
            int weight = Integer.parseInt(st.nextToken());
            nodeList[start].add(new node(end, weight));
            inDegree[end]++;
        }

        q.add(1);
        cntDP[1] = 1;

        while(!q.isEmpty()){
            int curIdx = q.poll();

            for(int i = 0 ; i < nodeList[curIdx].size() ; i++){
                node postNode = nodeList[curIdx].get(i);

                inDegree[postNode.idx]--;
                if(inDegree[postNode.idx] == 0){
                    q.add(postNode.idx);
                }

                if(disDP[postNode.idx] <= disDP[curIdx] + postNode.weight){
                    disDP[postNode.idx] = disDP[curIdx] + postNode.weight;
                    cntDP[postNode.idx] = Math.max(cntDP[postNode.idx], cntDP[curIdx] + 1);
                }
            }
        }

        System.out.print(disDP[n] + " " + cntDP[n]);

    
        
    }
}