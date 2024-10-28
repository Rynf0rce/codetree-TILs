import java.util.*;
import java.io.*;

public class Main {
    public static int MAX_N = 20;
    public static int MAX_LENGTH = 5;
    public static int[] arr = new int[MAX_N];
    public static int[][] table = new int[MAX_N][MAX_LENGTH];
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int num = 0;
        for(int i = 0 ; i < N ; i++){
            String str = br.readLine();
            arr[i] = Integer.parseInt(str);
            int idx = 0;
            for(int j = str.length() - 1 ; j >= 0 ; j--){
                table[i][idx++] = Integer.parseInt(str.charAt(j) + "");
            }
        }

        int ans = 0;
        boolean triger = true;
        for(int i = 0 ; i < N ; i++){
            for(int j = i + 1 ; j < N ; j++){
                for(int k = j + 1 ; k < N ; k++){
                    triger = true;
                    for(int h = 0 ; h < MAX_LENGTH ; h++){
                        if(table[i][h] + table[j][h] + table[k][h] >= 10){
                            triger = false;
                            break;
                        }
                    }
                    if(triger){
                        ans = Math.max(ans, arr[i] + arr[j] + arr[k]);
                    }
                }
            }
        }
        System.out.print(ans);
    }
}