import java.util.*;
import java.io.*;

public class Main {
    public static final int MAX_NODE = 1000;
    public static ArrayList<Integer>[] nodeList = new ArrayList[MAX_NODE + 1];
    public static int[] inDegree = new int[MAX_NODE + 1];
    public static int[] DP = new int[MAX_NODE + 1];
    public static int[] pressure = new int[MAX_NODE + 1];
    public static Queue<Integer> q = new LinkedList<>();

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
            inDegree[end]++;
        }

        for(int i = 1 ; i <= n ; i++){
            if(inDegree[i] == 0){
                pressure[i] = 1;
                DP[i] = 1;
                q.add(i);
            }
        }

        int ans = 0;
        while(!q.isEmpty()){
            int curIdx = q.poll();

            ans = Math.max(ans, DP[curIdx]);
            
            for(int i = 0 ; i < nodeList[curIdx].size() ; i++){
                int postIdx = nodeList[curIdx].get(i);

                if(pressure[postIdx] < DP[curIdx]){
                    pressure[postIdx] = DP[curIdx];
                    DP[postIdx] = DP[curIdx];
                }
                else if(pressure[postIdx] == DP[curIdx]){
                    DP[postIdx] = pressure[postIdx] + 1;
                }

                inDegree[postIdx]--;
                if(inDegree[postIdx] == 0){
                    q.add(postIdx);
                }
            }
        }

        // for(int i = 1 ; i <= n ; i++){
        //     System.out.print(pressure[i] + " ");
        // }

        System.out.println(ans);
    }
}