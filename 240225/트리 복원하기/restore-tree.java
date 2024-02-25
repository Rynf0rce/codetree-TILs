import java.util.*;
import java.io.*;

class path implements Comparable<path>{
    int left, right, weight;
    public path(int left, int right, int weight){
        this.left = left;
        this.right = right;
        this.weight = weight;
    }

    @Override
    public int compareTo(path p){
        if(this.weight == p.weight){
            if(this.left == p.left){
                return this.right - p.right;
            }
            else{
                return this.left - p.left;
            }
        }
        else{
            return this.weight - p.weight;
        }
    }
}

class ans implements Comparable<ans>{
    int left, right, weight;
    public ans(int left, int right, int weight){
        this.left = left;
        this.right = right;
        this.weight = weight;
    }

    @Override
    public int compareTo(ans p){
        if(this.left == p.left){
            return this.right - p.right;
        }
        else{
            return this.left - p.left;
        }
    }
}

public class Main {
    public static final int MAX_LENGTH = 500;
    public static int[][] table = new int[MAX_LENGTH + 1][MAX_LENGTH + 1];
    public static boolean[] visited = new boolean[MAX_LENGTH + 1];
    public static PriorityQueue<path> pq = new PriorityQueue<>();
    public static PriorityQueue<ans> ansPQ = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        for(int i = 1 ; i <= n ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 1 ; j <= n ; j++){
                table[i][j] = Integer.parseInt(st.nextToken());
                if(i != j){
                    pq.add(new path(i, j, table[i][j]));
                }
            }
        }

        while(!pq.isEmpty()){
            path curPath = pq.poll();
            if(visited[curPath.left] && visited[curPath.right]){
                continue;
            }
            visited[curPath.left] = true;
            visited[curPath.right] = true;
            ansPQ.add(new ans(curPath.left, curPath.right, curPath.weight));
            // System.out.println(curPath.left + " " + curPath.right + " " + curPath.weight);
        }

        while(!ansPQ.isEmpty()){
            ans ansString = ansPQ.poll();
            System.out.println(ansString.left + " " + ansString.right + " " + ansString.weight);
        }
    }
}