import java.util.*;
import java.io.*;

class node implements Comparable<node>{
    int idx, weight;

    public node(int idx, int weight){
        this.idx = idx;
        this.weight = weight;
    }

    @Override
    public int compareTo(node n){
        return this.weight - n.weight;
    }
}

public class Main { 
    public static final int MAX_EDGE = 30;
    public static final int MAX_WEIGHT = MAX_EDGE * MAX_EDGE * 1000000;
    public static char[][] table = new char[MAX_EDGE][MAX_EDGE];
    public static int[] weightArr = new int[MAX_EDGE * MAX_EDGE];
    public static int[] arrRow = new int[]{-1, 0, 1, 0};
    public static int[] arrCol = new int[]{0, 1, 0, -1};
    public static ArrayList<node>[] nodeList = new ArrayList[MAX_EDGE * MAX_EDGE];
    public static PriorityQueue<node> pq = new PriorityQueue<>();

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        for(int i = 0 ; i < N ; i++){
            String str = br.readLine();
            for(int j = 0 ; j < N ;j++){
                table[i][j] = str.charAt(j);
                weightArr[i * N + j] = MAX_WEIGHT;
            }
        }

        for(int i = 0 ; i < N * N ; i++){
            nodeList[i] = new ArrayList<node>();
        }

        for(int i = 0 ; i < N ; i++){
            for(int j = 0 ; j < N ; j++){
                int curRow = i;
                int curCol = j;
                for(int k = 0 ; k < 4 ; k++){
                    int postRow = i + arrRow[k];
                    int postCol = j + arrCol[k];

                    if(postRow < 0 || postCol < 0 || postRow >= N || postCol >= N){
                        continue;
                    }

                    int weight = table[curRow][curCol] == table[postRow][postCol] ? A : B;

                    nodeList[curRow * N + curCol].add(new node(postRow * N + postCol, weight));
                }
            }
        }

        weightArr[0] = 0;
        pq.add(new node(0, weightArr[0]));
        while(!pq.isEmpty()){
            node curNode = pq.poll();
            if(curNode.weight != weightArr[curNode.idx]){
                continue;
            }

            for(int i = 0 ; i < nodeList[curNode.idx].size() ; i++){
                node preNode = nodeList[curNode.idx].get(i);
                if(weightArr[preNode.idx] > curNode.weight + preNode.weight){
                    weightArr[preNode.idx] = curNode.weight + preNode.weight;
                    pq.add(new node(preNode.idx, weightArr[preNode.idx]));
                }
            }
        }

        int ans = 0;
        for(int i = 0 ; i < N * N ; i++){
            ans = Math.max(ans, weightArr[i]);
        }

        System.out.print(ans);
    }
}