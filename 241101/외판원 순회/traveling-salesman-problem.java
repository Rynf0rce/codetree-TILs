import java.util.*;
import java.io.*;

public class Main {
    public static final int MAX_LENGTH = 10;
    public static int[][] table = new int[MAX_LENGTH + 1][MAX_LENGTH + 1];

    public static ArrayList<Integer> arr = new ArrayList<>();
    public static boolean[] visited = new boolean[MAX_LENGTH + 1];

    public static int n = 0;
    public static int ans = (int) 1e9;

    public static void simulation(int idx){
        if(idx >= n){
            // System.out.println(arr);
            int val = table[1][arr.get(0)];

            if(val == 0){
                return;
            }

            for(int i = 1 ; i < arr.size(); i++){
                if(table[arr.get(i - 1)][arr.get(i)] == 0){
                    return;
                }
                val += table[arr.get(i - 1)][arr.get(i)];
            }

            if(table[arr.get(arr.size() - 1)][1] == 0){
                return;
            }

            val += table[arr.get(arr.size() - 1)][1];
            ans = Math.min(ans, val);
            return;
        }

        for(int i = 2 ; i <= n ; i++){
            if(visited[i]){
                continue;
            }

            visited[i] = true;
            arr.add(i);
            simulation(idx + 1);
            arr.remove(arr.size() - 1);
            visited[i] = false;
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        for(int i = 1 ; i <= n ; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for(int j = 1 ; j <= n ; j++){
                table[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        simulation(1);
        System.out.print(ans);
    }
}