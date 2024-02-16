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
    public static boolean[] removed = new boolean[MAX_NODE];
    public static int[] parents = new int[MAX_NODE];
    public static int[] dist = new int[MAX_NODE];
    public static int n = -1;

    public static void traversal(int idx){
        for(int i = 0 ; i < nodeList[idx].size() ; i++){
            node curNode = nodeList[idx].get(i);
            if(visited[curNode.idx] || removed[curNode.idx]){
                continue;
            }

            visited[curNode.idx] = true;
            parents[curNode.idx] = idx;
            dist[curNode.idx] = dist[idx] + curNode.weight;
            traversal(curNode.idx);
        }
    }

    public static int findMaxLength(){
        for(int i = 0 ; i < n ; i++){
            dist[i] = 0;
            parents[i] = 0;
            visited[i] = false;
        }

        visited[1] = true;
        traversal(1);

        int maxIdx = 0;
        for(int i = 0 ; i < n ; i++){
            if(dist[maxIdx] < dist[i]){
                maxIdx = i;
            }

            dist[i] = 0;
            parents[i] = 0;
            visited[i] = false;
        }

        visited[maxIdx] = true;
        traversal(maxIdx);
        int ans = 0;
        int tip = 0;
        for(int i = 0 ; i < n ; i++){
            if(dist[tip] < dist[i]){
                tip = i;
            }
            ans = Math.max(ans, dist[i]);
        }

        removed[maxIdx] = true;
        while(tip != maxIdx){
            removed[tip] = true;
            tip = parents[tip];
        }

        return ans;
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

        int longestLength = findMaxLength();
        int nextLength = findMaxLength();

        System.out.println(longestLength + nextLength);

    }
}