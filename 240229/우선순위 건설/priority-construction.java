import java.util.*;
import java.io.*;

public class Main {
    public static final int MAX_NODE = 500;
    public static ArrayList<Integer>[] nodeList = new ArrayList[MAX_NODE + 1];
    public static int[] time = new int[MAX_NODE + 1];
    public static int[] inDegree = new int[MAX_NODE + 1];
    public static int[] DP = new int[MAX_NODE + 1];
    public static Queue<Integer> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        for(int i = 1 ; i <= n ; i++){
            nodeList[i] = new ArrayList<>();
        }

        for(int i = 1 ; i <= n ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int t = Integer.parseInt(st.nextToken());
            time[i] = t;
            while(st.hasMoreTokens()){
                int start = Integer.parseInt(st.nextToken());
                if(start == -1){
                    break;
                }
                nodeList[start].add(i);
                inDegree[i]++;
            }
        }

        for(int i = 1 ; i <= n ; i++){
            if(inDegree[i] == 0){
                q.add(i);
                DP[i] = time[i];
            }
        }

        while(!q.isEmpty()){
            int curIdx = q.poll();

            for(int i = 0 ; i < nodeList[curIdx].size() ; i++){
                int postIdx = nodeList[curIdx].get(i);
                inDegree[postIdx]--;
                if(inDegree[postIdx] == 0){
                    q.add(postIdx);
                }

                DP[postIdx] = Math.max(DP[postIdx], DP[curIdx] + time[postIdx]);
            }
        }

        for(int i = 1 ; i <= n ; i++){
            System.out.println(DP[i]);
        }
    }
}