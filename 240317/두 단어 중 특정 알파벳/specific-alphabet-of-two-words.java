import java.util.*;
import java.io.*;

public class Main {
    public static final int NUM_OF_ALPHA = 26;
    public static int[] ans = new int[NUM_OF_ALPHA];
    public static int[] arr_A = new int[NUM_OF_ALPHA];
    public static int[] arr_B = new int[NUM_OF_ALPHA];

    public static void initialize(){
        for(int i = 0 ; i < NUM_OF_ALPHA ; i++){
            arr_A[i] = 0;
            arr_B[i] = 0;
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        for(int i = 0 ; i < n ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            String a = String.valueOf(st.nextToken());
            String b = String.valueOf(st.nextToken());

            initialize();

            for(int j = 0 ; j < a.length() ; j++){
                arr_A[a.charAt(j) - 'a']++;
            }

            for(int j = 0 ; j < b.length(); j++){
                arr_B[b.charAt(j) - 'a']++;
            }

            for(int j = 0 ; j < NUM_OF_ALPHA ; j++){
                ans[j] += Math.max(arr_A[j], arr_B[j]);
            }
        }

        for(int i = 0 ; i < NUM_OF_ALPHA ; i++){
            System.out.println(ans[i]);
        }
    }
}