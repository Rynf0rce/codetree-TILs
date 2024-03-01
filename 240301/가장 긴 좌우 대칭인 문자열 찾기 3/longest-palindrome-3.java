import java.util.*;
import java.io.*;

public class Main {
    public static final int MAX_LENGTH = 300000;
    public static char[] arr = new char[2 * MAX_LENGTH + 1];
    public static int[] A = new int[2 * MAX_LENGTH + 1];
    public static int n = -1;
    public static char c = ' ';

    public static void manacher(){
        int r = -1;
        int p = -1;
        for(int i = 0 ; i < n ; i++){
            if(arr[i] == c){
                continue;
            }

            if(r < i){
                A[i] = 0;
            }
            else{
                A[i] = Math.min(r - i, A[2 * p - i]);
            }

            while(i - A[i] - 1 >= 0 && i + A[i] + 1 < n && arr[i - A[i] - 1] == arr[i + A[i] + 1] && arr[i - A[i] - 1] != c){
                A[i]++;
            }

            if(r < i + A[i]){
                r = i + A[i];
                p = i;
            }
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        c = st.nextToken().charAt(0);
        String str = String.valueOf(br.readLine());

        for(int i = 0 ; i < str.length() ; i++){
            arr[2 * i] = '#';
            arr[2 * i + 1] = str.charAt(i);
        }

        n = 2 * n + 1;
        arr[n - 1] = '#';
        manacher();

        int ans = 0;
        for(int i = 0 ; i < n ; i++){
            ans = Math.max(ans, A[i] * 2 + 1);
        }

        System.out.print(ans / 2);
    }
}