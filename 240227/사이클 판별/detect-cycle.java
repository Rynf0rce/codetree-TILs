import java.util.*;
import java.io.*;

public class Main {
    public static final int MAX_NODE = 100000;
    public static ArrayList<Integer>[] nodeList = new ArrayList[MAX_NODE + 1];
    public static int[] inOrder = new int[MAX_NODE + 1];
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
            inOrder[end]++;
        }

        for(int i = 1 ; i <= n ; i++){
            if(inOrder[i] == 0){
                q.add(i);
            }
        }

        int ans = 0;
        while(!q.isEmpty()){
            int curIdx = q.poll();
            ans++;
            for(int i = 0 ; i < nodeList[curIdx].size() ; i++){
                int postIdx = nodeList[curIdx].get(i);
                inOrder[postIdx]--;
                if(inOrder[postIdx] == 0){
                    q.add(postIdx);
                }
            }
        }

        System.out.print(ans == n ? "Not Exists" : "Exists");
    }
}