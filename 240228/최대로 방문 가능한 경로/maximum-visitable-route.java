import java.util.*;
import java.io.*;

public class Main {
    public static final int MAX_NODE = 100000;
    public static ArrayList<Integer>[] nodeList = new ArrayList[MAX_NODE + 1];
    public static int[] inDegree = new int[MAX_NODE + 1];
    public static int[] DP = new int[MAX_NODE + 1];
    public static int[] connect = new int[MAX_NODE + 1];
    public static Queue<Integer> q = new LinkedList<>();
    public static ArrayList<Integer> ansList = new ArrayList<>();

    public static void topological(){
        while(!q.isEmpty()){
            int curIdx = q.poll();
            for(int i = 0 ; i < nodeList[curIdx].size() ; i++){
                int postIdx = nodeList[curIdx].get(i);

                inDegree[postIdx]--;
                if(inDegree[postIdx] == 0){
                    q.add(postIdx);
                }
            }
        }
    }

    public static void findAns(){
        while(!q.isEmpty()){
            int curIdx = q.poll();
            for(int i = 0 ; i < nodeList[curIdx].size() ; i++){
                int postIdx = nodeList[curIdx].get(i);

                inDegree[postIdx]--;
                if(inDegree[postIdx] == 0){
                    q.add(postIdx);
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

        for(int i = 2 ; i <= n ; i++){
            if(inDegree[i] == 0){
                q.add(i);
                DP[i] = 1;
            }
        }

        topological();

        q.add(1);
        DP[1] = 1;
        findAns();

        int idx = n;
        while(true){
            ansList.add(idx);
            idx = connect[idx];
            if(idx == 0){
                break;
            }
        }

        if(ansList.get(ansList.size() - 1) != 1 || ansList.get(0) != n){
            System.out.print(-1);
        }
        else{
            System.out.println(ansList.size());
            for(int i = ansList.size() - 1 ; i >= 0 ; i--){
                System.out.print(ansList.get(i) + " ");
            }
        }
    }
}