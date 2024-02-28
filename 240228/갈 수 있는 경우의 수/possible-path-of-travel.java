import java.util.*;
import java.io.*;

public class Main {
    public static final int MAX_NODE = 100000;
    public static final int START_IDX = 1;
    public static final int MOD = 1000000007;
    public static ArrayList<Integer>[] nodeList = new ArrayList[MAX_NODE + 1];
    public static Queue<Integer> q = new LinkedList<>();
    public static int[] inDegree = new int[MAX_NODE + 1];
    public static int[] DP = new int[MAX_NODE + 1]; // DP[i] = sigma(DP[panIn]); DP[1] = 1;

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

            nodeList[start].add(end);
            inDegree[end]++;
        }

        q.add(START_IDX);
        DP[START_IDX] = 1;

        while(!q.isEmpty()){
            int curIdx = q.poll();

            for(int i = 0 ; i < nodeList[curIdx].size() ; i++){
                int postIdx = nodeList[curIdx].get(i);
                DP[postIdx] += DP[curIdx];
                inDegree[postIdx]--;
                if(inDegree[postIdx] == 0){
                    q.add(postIdx);
                }
            }
        }

        System.out.print(DP[n] % MOD);
    }
}