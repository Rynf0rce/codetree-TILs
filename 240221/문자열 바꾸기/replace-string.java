import java.util.*;
import java.io.*;

public class Main {
    public static int NUM_ALPHABET = 26;
    public static int[] cnt_A = new int[NUM_ALPHABET];
    public static int[] cnt_B = new int[NUM_ALPHABET];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] arr_A = br.readLine().toCharArray();
        char[] arr_B = br.readLine().toCharArray();

        for(int i = 0 ; i < arr_A.length ; i++){
            cnt_A[arr_A[i] - 'A']++;
            cnt_B[arr_B[i] - 'A']++;
        }

        for(int i = 0 ; i < NUM_ALPHABET ; i++){
            if(cnt_A[i] != cnt_B[i]){
                System.out.print(-1);
                System.exit(0);
            }
        }
        
        int ans = arr_A.length - 1;
        for(int i = arr_A.length - 1 ; i >= 0 ; i--){
            if(arr_A[i] == arr_B[i]){
                ans--;
            }
            else{
                break;
            }
        }

        System.out.print(ans);



    }
}