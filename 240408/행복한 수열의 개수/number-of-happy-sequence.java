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
            s.clear();
            boolean flag = false;
            for(int j = 0 ; j < n ; j++){
                if(s.isEmpty()){
                    s.add(table[i][j]);
                }
                else if(s.peek() == table[i][j]){
                    s.add(table[i][j]);
                }
                else{
                    s.clear();
                    s.add(table[i][j]);
                }

                if(s.size() >= m){
                    flag = true;
                    break;
                }
            }

            if(flag){
                ans++;
            }
        }

        for(int j = 0 ; j < n ; j++){
            s.clear();
            boolean flag = false;
            for(int i = 0 ; i < n ; i++){
                if(s.isEmpty()){
                    s.add(table[i][j]);
                }
                else if(s.peek() == table[i][j]){
                    s.add(table[i][j]);
                }
                else{
                    s.clear();
                    s.add(table[i][j]);
                }

                if(s.size() >= m){
                    flag = true;
                    break;
                }
            }

            if(flag){
                ans++;
            }
        }
        System.out.print(ans);
    }
}