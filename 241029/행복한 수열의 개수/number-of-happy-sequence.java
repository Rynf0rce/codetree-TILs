import java.util.*;
import java.io.*;

public class Main {
    public static final int MAX_LENGTH = 100;
    public static int[][] table = new int[MAX_LENGTH][MAX_LENGTH];
    public static Stack<Integer> s = new Stack<>();

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        for(int i = 0 ; i < n ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0 ; j < n ; j++){
                table[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int ans = 0;
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                if(s.isEmpty() || s.peek() == table[i][j]){
                    s.add(table[i][j]);
                }
                else{
                    s.clear();
                    s.add(table[i][j]);
                }
                
                if(s.size() >= m){
                    // System.out.println("row" + i + " " + j + " " + s.peek());
                    ans++;
                    break;
                }
            }
            s.clear();
        }

        for(int j = 0 ; j < n ; j++){
            for(int i = 0 ; i < n ; i++){
                if(s.isEmpty() || s.peek() == table[i][j]){
                    s.add(table[i][j]);
                }
                else{
                    s.clear();
                    s.add(table[i][j]);
                }
                
                if(s.size() >= m){
                    // System.out.println("col" + i + " " + j + " " + s.peek());
                    ans++;
                    break;
                }
            }
            s.clear();
        }

        System.out.print(ans);
    }
}