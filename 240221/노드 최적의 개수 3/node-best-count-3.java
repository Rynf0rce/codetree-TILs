import java.util.*;
import java.io.*;

public class Main {
    public static final int MAX_NODE = 100000;
    public static ArrayList<Integer>[] nodeList = new ArrayList[MAX_NODE + 1];
    public static int[] parents = new int[MAX_NODE + 1];
    public static TreeMap<Integer, TreeSet<Integer>> childMap = new TreeMap<>();
    public static boolean[] visited = new boolean[MAX_NODE + 1];
    public static int[][] DP = new int[MAX_NODE][2]; // [정점 노드][조건 만족 여부][선택 여부]

    public static void dfs(int idx){
        for(int i = 0 ; i < nodeList[idx].size(); i++){
            int postIdx = nodeList[idx].get(i);
            if(visited[postIdx]){
                continue;
            }
            visited[postIdx] = true;
            childMap.get(idx).add(postIdx);
            parents[postIdx] = idx;
            dfs(postIdx);
        }

        if(childMap.get(idx).isEmpty()){
            DP[idx][1] = 1;
            DP[idx][0] = MAX_NODE + 1;
            return;
        }

        DP[idx][1]= 1;
        boolean isSelected = false;
        int selelctedValue = MAX_NODE + 1;
        for(int i = 0 ; i < nodeList[idx].size() ; i++){
            int postIdx = nodeList[idx].get(i);
            if(parents[postIdx] != idx){
                continue;
            }

            // case of leafNode
            if(childMap.get(postIdx).isEmpty()){
                DP[idx][0] += DP[postIdx][1];
                isSelected = true;
            }
            else{
                // Consider this situation children of DP[idx][1] isn't selelcted but their children is selected
                int subChildSum = 0;
                for(int subChild : childMap.get(postIdx)){
                    subChildSum += Math.min(DP[subChild][1], DP[subChild][0]); 
                }

                if(!childMap.get(postIdx).isEmpty()){
                    DP[idx][1] += Math.min( Math.min(DP[postIdx][1], DP[postIdx][0]), subChildSum);
                }
                else{
                    DP[idx][1] += Math.min(DP[postIdx][1], DP[postIdx][0]);
                }

                DP[idx][0] += Math.min(DP[postIdx][1], DP[postIdx][0]);

                // If their children isn't selected in DP[idx][0], It is not satisfied by condtion;
                if(DP[postIdx][1] > DP[postIdx][0]){
                    isSelected = true;
                }

                // At least, There are must being selelcted node;
                selelctedValue = Math.min(selelctedValue, DP[postIdx][1] - DP[postIdx][0]);
            }

            if(!isSelected){
                DP[postIdx][0] += selelctedValue;
            }
        }
        
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for(int i = 1 ; i <= n ; i++){
            nodeList[i] = new ArrayList<>();
            childMap.put(i, new TreeSet<Integer>());
        }

        StringTokenizer st;
        for(int i = 1 ; i < n ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end =  Integer.parseInt(st.nextToken());
            nodeList[start].add(end);
            nodeList[end].add(start);
        }

        visited[1] = true;
        dfs(1);

        System.out.print(Math.min(DP[1][1], DP[1][0]));
    }
}