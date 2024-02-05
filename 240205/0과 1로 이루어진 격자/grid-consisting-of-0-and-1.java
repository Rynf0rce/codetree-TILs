import java.util.*;
import java.io.*;

public class Main {
    public static final int MAX_EDGE = 10;
    public static boolean[][] table = new boolean[MAX_EDGE][MAX_EDGE];
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());

        for(int i = 0 ; i < n ; i++){
            String str = br.readLine();
            for(int j = 0 ; j < n ; j++){
                if(str.charAt(j) == '1'){
                    table[i][j] = true;
                }
            }
        }

        int cnt = 0;
        for(int i = n - 1 ; i >= 0 ; i--){
            for(int j = n - 1 ; j >= 0 ; j--){
                if(table[i][j]){
                    cnt++;
                    for(int k = 0 ; k <= i ; k++){
                        for(int h = 0 ; h <= j ; h++){
                            if(table[k][h]){
                                table[k][h] = false;
                            }
                            else{
                                table[k][h] = true;
                            }
                        }
                    }
                }
            }
        }

        System.out.print(cnt);
    }
}