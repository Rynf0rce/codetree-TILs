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
    public static final int MAX_NODE = 2000;
    public static ArrayList<node>[] nodeList = new ArrayList[MAX_NODE];
    public static boolean[] visited = new boolean[MAX_NODE];
    public static int[] dist = new int[MAX_NODE];
    public static int[] parents = new int[MAX_NODE];
    public static int n = -1;

    public static void initialize(){
        for(int i = 0 ; i < n ; i++){
            dist[i] = 0;
            visited[i] = false;
        }
    }

    public static void traversal(int idx){
        for(int i = 0 ; i < nodeList[idx].size() ; i++){
            node curNode = nodeList[idx].get(i);
            if(visited[curNode.idx]){
                continue;
            }

            visited[curNode.idx] = true;
            parents[curNode.idx] = idx;
            traversal(curNode.idx);
        }
    }

    public static void DFS(int idx){
        for(int i = 0 ; i < nodeList[idx].size() ; i++){
            node curNode = nodeList[idx].get(i);
            if(visited[curNode.idx]){
                continue;
            }

            visited[curNode.idx] = true;
            dist[curNode.idx] = curNode.weight + dist[idx];
            DFS(curNode.idx);
        }
    }

    public static int findLongest(int removeIdx){
        int dividedMax = 0;
        int remainMax = 0;

        // 짤려진 부분 최대 길이 구하기
        initialize();
        visited[removeIdx] = true;
        visited[parents[removeIdx]] = true;
        DFS(removeIdx);
        
        int maxIdx = 0;
        boolean triger = true;
        for(int i = 0 ; i < n ; i++){
            if(dist[maxIdx] < dist[i]){
                triger = false;
                maxIdx = i;
            }
        }

        if(triger){
            dividedMax = 0;
        }
        else{
            initialize();
            visited[maxIdx] = true;
            visited[parents[removeIdx]] = true;
            DFS(maxIdx);
            
            for(int i = 0 ; i < n ; i++){
                dividedMax = Math.max(dividedMax, dist[i]);
            }
        }
        

        // 남은 부분 트리 최종 길이 계산하기
        initialize();
        visited[removeIdx] = true;
        visited[parents[removeIdx]] = true;
        DFS(parents[removeIdx]);
        
        maxIdx = 0;
        for(int i = 0 ; i < n ; i++){
            if(dist[maxIdx] < dist[i]){
                maxIdx = i;
            }
        }

        initialize();
        visited[maxIdx] = true;
        visited[removeIdx] = true;
        DFS(maxIdx);
        
        for(int i = 0 ; i < n ; i++){
            remainMax = Math.max(remainMax, dist[i]);
        }

        int connectedLength = 0;
        for(int i = 0 ; i < nodeList[removeIdx].size() ; i++){
            node curNode = nodeList[removeIdx].get(i);
            if(curNode.idx == parents[removeIdx]){
                connectedLength = curNode.weight;
                break;
            }
        }

        // System.out.println(dividedMax + " " + connectedLength + " " + remainMax);
        return dividedMax + connectedLength + remainMax;
    }



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        for(int i = 0 ; i < n ; i++){
            nodeList[i] = new ArrayList<node>();
        }

        StringTokenizer st;
        for(int i = 1 ; i < n ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            nodeList[start].add(new node(end, weight));
            nodeList[end].add(new node(start, weight));
        }

        visited[0] = true;
        traversal(0);
        // System.out.println(findLongest(3));

        int ans = 0;
        for(int i = 1 ; i < n ; i++){
            ans = Math.max(ans, findLongest(i));
        }

        System.out.println(ans);
    }
}