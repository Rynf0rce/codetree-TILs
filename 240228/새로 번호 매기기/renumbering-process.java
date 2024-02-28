import java.util.*;
import java.io.*;

class node implements Comparable<node>{
    int left, right, in;
    public node(int left, int right, int in){
        this.left = left;
        this.right = right;
        this.in = in;
    }

    @Override
    public int compareTo(node n){
        if(this.in == n.in){
            if(this.left == n.left){
                return this.right - n.right;
            }

            return this.left - n.left;
        }
        return this.in - n.in;
    }
}

public class Main {
    public static final int MAX_NODE = 100000;
    public static ArrayList<Integer>[] nodeList = new ArrayList[MAX_NODE + 1];
    public static int[] panIn = new int[MAX_NODE + 1];
    public static int[] ans = new int[MAX_NODE + 1];
    public static boolean[] visited = new boolean[MAX_NODE + 1];
    public static PriorityQueue<node> pq = new PriorityQueue<>();

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
            panIn[end]++;
        }

        for(int i = 1 ; i <= n ; i++){
            if(panIn[i] == 0){
                for(int j = 0 ; j < nodeList[i].size() ; j++){
                    int postIdx = nodeList[i].get(j);
                    pq.add(new node(i, postIdx, panIn[postIdx]));
                }
            }
        }

        int cnt = 1;
        while(!pq.isEmpty()){
            node curNode = pq.poll();
            
            if(visited[curNode.left]){
                continue;
            }
            visited[curNode.left] = true;
            ans[curNode.left] = cnt++;

            for(int i = 0 ; i < nodeList[curNode.left].size() ; i++){
                int postIdx = nodeList[curNode.left].get(i);
                panIn[postIdx]--;
                if(panIn[postIdx] == 0){
                    for(int j = 0 ; j < nodeList[postIdx].size() ; j++){
                        int grandPostIdx = nodeList[postIdx].get(j);
                        pq.add(new node(postIdx, grandPostIdx, panIn[grandPostIdx]));
                    }

                    if(nodeList[postIdx].size() == 0){
                        pq.add(new node(postIdx, postIdx, panIn[postIdx]));
                    }
                }
            }
        }

        boolean flag = false;
        for(int i = 1 ; i <= n ; i++){
            if(panIn[i] > 0){
                flag = true;
                break;
            }
        }

        if(flag){
            System.out.print(-1);
        }
        else{
            for(int i = 1 ; i <= n ; i++){
                System.out.print(ans[i] + " ");
            }
        }
    }
}