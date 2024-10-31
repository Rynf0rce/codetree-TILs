import java.util.*;
import java.io.*;

public class Main {
    public static final int MAX_LENGTH = 5000;
    public static int[][] table = new int[4][MAX_LENGTH];
    public static HashMap<Integer, Integer> leftMap = new HashMap<>();
    public static HashMap<Integer, Integer> rightMap = new HashMap<>();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        for(int i = 0 ; i <= 3 ; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0 ; j < n ; j++){
                table[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                leftMap.put(table[0][i] + table[1][j], leftMap.getOrDefault(table[0][i] + table[1][j], 0) + 1);
            }   
        }

        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                rightMap.put(table[2][i] + table[3][j], rightMap.getOrDefault(table[2][i] + table[3][j], 0) + 1);
            }   
        }

        int ans = 0;
        for(Map.Entry<Integer, Integer> e : leftMap.entrySet()){
            int reverse = e.getKey() * -1;
            if(rightMap.getOrDefault(reverse, 0) > 0){
                ans += e.getValue() * rightMap.get(reverse);
            }
        }
        System.out.print(ans);
    }
}