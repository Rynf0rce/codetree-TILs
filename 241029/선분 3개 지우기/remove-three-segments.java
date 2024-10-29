import java.util.*;
import java.io.*;
public class Main {
    public static final int MAX_LENGTH = 100;
    public static final int MAX_LINE = 10;
    public static int[][] table = new int[MAX_LINE][MAX_LENGTH + 1];
    public static int[] arr = new int[MAX_LENGTH + 1];
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for(int i = 0 ; i < n ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int left = Integer.parseInt(st.nextToken());
            int right = Integer.parseInt(st.nextToken());
            for(int j = left ; j <= right ; j++){
                table[i][j] = 1;
            }
        }
        
        int ans = 0;
        for(int i = 0 ; i < n - 2; i++){
            for(int j = i + 1 ; j < n - 1; j++){
                for(int k = j + 1 ; k < n ; k++){
                    boolean triger = true;
                    for(int h = 0 ; h <= MAX_LENGTH  ; h++){
                        int cnt = 0;
                        for(int f = 0 ; f < n ; f++){
                            if(f == i || f == j | f == k){
                                continue;
                            }
                            cnt += table[f][h];
                        }

                        if(cnt > 1){
                            triger = false;
                            break;
                        }
                    }
                    if(triger){
                        ans++;
                    }
                }
            }
        }
        System.out.print(ans);
    }
}