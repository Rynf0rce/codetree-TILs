import java.util.*;
import java.io.*;

public class Main {
    public static final int MAX_NODE = 500;
    public static ArrayList<Integer>[] nodeList = new ArrayList[MAX_NODE + 1];
    public static boolean[] visited = new boolean[MAX_NODE + 1];
    public static Queue<Integer> q = new LinkedList<>();
    public static int n = -1;
    
    public static boolean traversal(int idx){
        boolean ans = true;
        q.add(idx);
        while(!q.isEmpty()){
            int curIdx = q.poll();
            if(visited[curIdx]){
                continue;
            }
            // System.out.println(curIdx);
            visited[curIdx] = true;

            for(int i = 0 ; i < nodeList[curIdx].size() ; i++){
                int postIdx = nodeList[curIdx].get(i);
                if(visited[postIdx]){
                    continue;
                }

                if(q.contains(postIdx)){
                    ans = false;
                }
                else{
                    q.add(postIdx);
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        for(int i = 1 ; i <= n ; i++){
            nodeList[i] = new ArrayList<>();
        }

        int m = Integer.parseInt(st.nextToken());
        for(int i = 0 ; i < m ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            nodeList[start].add(end);
            nodeList[end].add(start);
        }

        int ans = 0;
        for(int i = 1 ; i <= n ; i++){
            if(visited[i]){
                continue;
            }

            if(traversal(i)){
                ans++;
            }
        }

        System.out.println(ans);

    }
}