import java.util.*;
import java.io.*;

public class Main {
    public static final int MAX_LENGTH = 20;
    public static int[][] table = new int[MAX_LENGTH][MAX_LENGTH];
    public static Queue<Integer> q = new LinkedList<>();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        for(int i = 0 ; i < n ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0 ; j < n ; j++){
                table[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int ans = 0;
        for(int i = 0 ; i < n ; i++){
            q.clear();
            int cnt = 0;
            for(int j = 0 ; j < n ; j++){
                q.add(table[i][j]);

                if(table[i][j] == 1){
                    cnt++;
                }

                if(q.size() >= 3){
                    ans = Math.max(ans, cnt);
                    if(q.poll() == 1){
                        cnt--;
                    }
                }
            }
        }

        System.out.print(ans);
    }
}