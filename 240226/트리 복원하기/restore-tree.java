import java.util.*;
import java.io.*;

class tuple implements Comparable<tuple>{
    int left, right, weight;
    public tuple(int left, int right, int weight){
        this.left = left;
        this.right = right;
        this.weight = weight;
    }

    @Override
    public int compareTo(tuple t){
        if(this.left != t.left){
            return this.left - t.left;
        }
        if(this.right != t.right){
            return this.right - t.right;
        }
        return this.weight - t.weight;
    }
}

public class Main {
    public static final int MAX_LENGTH = 500;
    public static final int INVALID = (int) 1e9;
    public static final int START_IDX = 1;
    public static int[][] table = new int[MAX_LENGTH + 1][MAX_LENGTH + 1];
    public static boolean[] visited = new boolean[MAX_LENGTH + 1];
    public static int[] dist = new int[MAX_LENGTH + 1];
    public static int[] connected = new int[MAX_LENGTH + 1];
    public static ArrayList<tuple> tupleList = new ArrayList<>();


    public static int n = -1;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        for(int i = 1 ; i <= n ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 1 ; j <= n ; j++){
                table[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 1 ; i <= n ; i++){
            dist[i] = INVALID;
        }

        dist[START_IDX] = 0;
        for(int i = 1 ; i <= n ; i++){
            int minIdx = -1;
            for(int j = 1 ; j <= n ; j++){
                if(visited[j]){
                    continue;
                }

                if(minIdx == -1 || dist[minIdx] > dist[j]){
                    minIdx = j;
                }
            }

            visited[minIdx] = true;

            if(minIdx != START_IDX){
                tupleList.add(new tuple(Math.min(minIdx, connected[minIdx]), Math.max(minIdx, connected[minIdx]), dist[minIdx]));
            }

            for(int j = 1 ; j <= n ; j++){
                if(table[minIdx][j] == 0){
                    continue; // loop
                }
                
                if(dist[j] > table[minIdx][j]){
                    dist[j] = table[minIdx][j];
                    connected[j] = minIdx;
                }
            }
        }

        Collections.sort(tupleList);
        for(tuple t : tupleList){
            System.out.println(t.left + " " + t.right + " " + t.weight);
        }
    }
}