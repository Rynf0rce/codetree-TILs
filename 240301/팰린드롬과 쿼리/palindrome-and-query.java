import java.util.*;
import java.io.*;

public class Main {
    public static final int MAX_LENGTH = 100000;
    public static char[] arr = new char[MAX_LENGTH * 2 + 1];
    public static int[] A = new int[MAX_LENGTH * 2 + 1];
    public static int n = -1;

    public static void manacher(){
        int r = -1, p = -1;
        for(int i = 0 ; i < n ; i++){
            if(r < i){
                A[i] = 0;
            }
            else{
                A[i] = Math.min(r - i, A[2 * p - i]);
            }

            while(i - A[i] - 1 >= 0 && i + A[i] + 1 < n && arr[i - A[i] - 1] == arr[i + A[i] + 1]){
                A[i]++;
            }

            if(r < i + A[i]){
                r = i + A[i];
                p = i;
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());
        
        String str = String.valueOf(br.readLine());
        for(int i = 0 ; i < str.length() ; i++){
            arr[2 * i] = '#';
            arr[2 * i + 1] = str.charAt(i);
        }

        n = n * 2 + 1;
        arr[n - 1] = '#';
        manacher();

        // for(int i = 0 ; i < n ; i++){
        //     System.out.print(A[i] + " ");
        // }

        for(int i = 0 ; i < q ; i++){
            st = new StringTokenizer(br.readLine());
            int start = (Integer.parseInt(st.nextToken()) - 1) * 2 + 1;
            int end = (Integer.parseInt(st.nextToken()) - 1) * 2 + 1;
            System.out.println(A[(start + end + 1)/ 2] > 0 ? "Yes" : "No");
        }

    }
}