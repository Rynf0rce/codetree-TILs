import java.util.*;
import java.io.*;

public class Main {
    public static final int MAX_LENGTH = 10;
    public static int[][] table = new int[MAX_LENGTH][MAX_LENGTH];
    public static HashSet<Integer> colVisited = new HashSet<>();
    public static ArrayList<Integer> selected = new ArrayList<>();
    public static int n = 0;
    public static int ans = 0;


    public static void findVal(int idx){    
        if(idx >= n){
            int sum = 0;
            for(int num : selected){
                sum += num;
            }
            ans = Math.max(ans, sum);
            return;
        }

        for(int i = 0 ; i < n ; i++){
            if(colVisited.contains(i)){
                continue;
            }
            colVisited.add(i);
            selected.add(table[idx][i]);
            findVal(idx + 1);
            selected.remove(selected.size() - 1);
            colVisited.remove(i);
        }

    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        for(int i = 0 ; i < n ; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0 ; j < n ; j++){
                table[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        findVal(0);

        System.out.print(ans);        
    }
}