// Traveling Salesman problem (TSP)

import java.util.*;

public class Main {
    public static final int MAX_RANGE = 10;
    public static int[][] table = new int[MAX_RANGE][MAX_RANGE];
    public static ArrayList<Integer> vector = new ArrayList<>();
    public static boolean[] visited = new boolean[MAX_RANGE];
    public static int minVal = Integer.MAX_VALUE;
    public static int n;

    public static void TSP(int curIdx, int distance){
        if(vector.size() >= n){
            if(table[curIdx][0] != 0){
                minVal = Math.min(minVal, distance + table[curIdx][0]);
            }
            return;
        }

        for(int i = 1 ; i < n ; i++){
            if(visited[i] || table[curIdx][i] == 0){
                continue;
            }

            visited[i] = true;
            vector.add(i);
            TSP(i, distance + table[curIdx][i]);
            vector.remove(vector.size() - 1);
            visited[i] = false;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                table[i][j] = sc.nextInt();
            }
        }

        vector.add(0);
        TSP(0, 0);

        System.out.print(minVal);
    }
}