import java.util.*;
import java.io.*;

public class Main {
    public static final int MAX_LENGTH = 10;
    public static int[][] table = new int[MAX_LENGTH][MAX_LENGTH];
    public static HashSet<Integer> rowVisited = new HashSet<>();
    public static HashSet<Integer> colVisited = new HashSet<>();
    public static ArrayList<Integer> selected = new ArrayList<>();
    public static int n = 0;
    public static int ans = 0;


    public static void findVal(int r, int c, int cnt){    
        if(cnt == n){
            int sum = 0;
            for(int num : selected){
                sum += num;
            }
            ans = Math.max(ans, sum);
            return;
        }

        if(r >= n){
            return;
        }

        for(int i = r ; i < n ; i++){
            if(rowVisited.contains(i)){
                continue;
            }
            for(int j = c ; j < n ; j++){
                if(colVisited.contains(j)){
                    continue;
                }

                int goRow = r;
                int goCol = c + 1;
                if(c + 1 >= n){
                    goRow++;
                    goCol = 0;
                }
                
                selected.add(table[i][j]);
                rowVisited.add(i);
                colVisited.add(j);
                findVal(goRow, goCol, cnt + 1);
                colVisited.remove(j);
                rowVisited.remove(i);
                selected.remove(selected.size() - 1);

                findVal(goRow, goCol, cnt);
            }
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

        findVal(0, 0, 0);

        System.out.print(ans);        
    }
}