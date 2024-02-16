import java.util.*;
import java.io.*;

public class Main {
    public static final int MAX_NODE = 100000;
    public static ArrayList<Integer>[] nodeList = new ArrayList[MAX_NODE + 1];
    public static boolean[] visited = new boolean[MAX_NODE + 1];
    public static int[] depthArr = new int[MAX_NODE + 1];
    public static int n = -1;

    public static void initialize(){
        for(int i = 1 ; i <= n ; i++){
            visited[i] = false;
            depthArr[i] = 0;
        }
    }

    public static void traversal(int idx){
        for(int i = 0 ; i < nodeList[idx].size() ; i++){
            int curIdx = nodeList[idx].get(i);
            if(!visited[curIdx]){
                visited[curIdx] = true;
                depthArr[curIdx] = depthArr[idx] + 1;
                traversal(curIdx);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        for(int i = 1 ; i <= n ; i++){
            nodeList[i] = new ArrayList<>();
        }

        StringTokenizer st;
        for(int i = 1 ; i < n ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            nodeList[start].add(end);
            nodeList[end].add(start);
        }

        visited[1] = true;
        traversal(1);

        int maxIdx = 1;
        for(int i = 1 ; i <= n ; i++){
            if(depthArr[maxIdx] < depthArr[i]){
                maxIdx = i;
            }
        }

        initialize();
        visited[maxIdx] = true;
        traversal(maxIdx);

        int ans = 1 ;
        for(int i = 1 ; i <= n ; i++){
            ans = Math.max(ans, depthArr[i]);
        }

        if(ans % 2 == 0){
            ans /= 2;
        }
        else{
            ans = (ans + 1) / 2;
        }

        System.out.print(ans);

    }
}