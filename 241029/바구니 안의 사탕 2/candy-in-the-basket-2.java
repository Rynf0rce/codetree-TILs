import java.util.*;
import java.io.*;
public class Main {
    public static final int MAX_LENGTH = 100;
    public static int[] arr = new int[MAX_LENGTH + 2];
    public static int[] prefix = new int[MAX_LENGTH + 2];

    public static boolean inRange (int idx){
        return idx >= 0 && idx <= 100;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        
        for(int i = 0 ; i < N ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int candy = Integer.parseInt(st.nextToken());
            int loc = Integer.parseInt(st.nextToken());
            arr[loc] += candy;
        }

        prefix[0] = arr[0];
        for(int i = 0 ; i <= MAX_LENGTH ; i++){
            prefix[i + 1] = prefix[i] + arr[i + 1];
        }

        // for(int i = 0 ; i <= 15 ; i++){
        //     System.out.print(prefix[i] + " ");
        // }

        int left = 0;
        int right = 0;
        int ans = 0;
        for(int i = 0 ; i <= MAX_LENGTH ; i++){
            if(i == 0){
                left = 0;
            }
            else{
                left = prefix[i - 1];
            }

            if(i + 2 * K > MAX_LENGTH){
                right = prefix[MAX_LENGTH];
            }
            else{
                right = prefix[i + 2 * K];
            }

            ans = Math.max(ans, right - left);
        }

        System.out.print(ans);
    }
}