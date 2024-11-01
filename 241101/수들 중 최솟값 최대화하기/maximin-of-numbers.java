import java.util.*;
import java.io.*;

public class Main {
    public static final int MAX_LENGTH = 10;

    public static int n = 0;
    public static int ans = 0;
    public static int[][] table = new int[MAX_LENGTH][MAX_LENGTH];
    public static boolean[] visited = new boolean[MAX_LENGTH];
    public static ArrayList<Integer> selected = new ArrayList<>();

    public static void simulation(int row){
        if(row >= n){
            int val = (int) 1e9;
            for(int num : selected){
                val = Math.min(val, num);
            }
            ans = Math.max(ans, val);
            return;
        }

        for(int i = 0 ; i < n ; i++){
            if(visited[i]){
                continue;
            }

            visited[i] = true;
            selected.add(table[row][i]);
            simulation(row + 1);
            selected.remove(selected.size() - 1);
            visited[i] = false;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        for(int i = 0 ; i < n ; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0 ; j < n ; j++){
                table[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        simulation(0);

        System.out.print(ans);   
    }
}