import java.util.*;
import java.io.*;


public class Main {
    public static final int MAX_NODE = 10000;
    public static ArrayList<Integer>[] nodeList = new ArrayList[MAX_NODE + 1];
    public static int[] inDegree = new int[MAX_NODE + 1];
    public static int[] cost = new int[MAX_NODE + 1];
    public static int[] DP = new int[MAX_NODE + 1];
    public static Queue<Integer> q = new LinkedList<>();

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        for(int i = 1 ; i <= n ; i++){
            nodeList[i] = new ArrayList<>();
        }

        for(int i = 1 ; i <= n ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int weight = Integer.parseInt(st.nextToken());
            int prior = Integer.parseInt(st.nextToken());
            cost[i] = weight;
            for(int j = 0 ; j < prior ; j++){
                int priorIdx = Integer.parseInt(st.nextToken());
                nodeList[priorIdx].add(i);
                inDegree[i]++;
            }
        }

        for(int i = 1 ; i <= n ; i++){
            if(inDegree[i] == 0){
                q.add(i);
            }
        }

        while(!q.isEmpty()){
            int curIdx = q.poll();
            DP[curIdx] = Math.max(DP[curIdx], cost[curIdx]);

            for(int i = 0 ; i < nodeList[curIdx].size() ; i++){
                int postIdx = nodeList[curIdx].get(i);
                int neededTime = DP[curIdx] + cost[postIdx];
                DP[postIdx] = Math.max(DP[postIdx], neededTime);
                inDegree[postIdx]--;
                if(inDegree[postIdx] == 0){
                    q.add(postIdx);
                }
            }
        }

        int ans = 0;
        for(int i = 1 ; i <= n ; i++){
            ans = Math.max(ans, DP[i]);
        }
        System.out.print(ans);
    }
}