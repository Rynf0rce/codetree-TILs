import java.util.*;
import java.io.*;

public class Main {
    public static final int MAX_LENGTH = 100000;
    public static int[] arr = new int[MAX_LENGTH + 1];
    public static int[] leftArr = new int[MAX_LENGTH + 2];
    public static int[] rightArr = new int[MAX_LENGTH + 2];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 1 ; i <= n ; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        leftArr[1] = arr[1];
        for(int i = 2 ; i <= n ; i++){
            leftArr[i] = Math.max(leftArr[i - 1], arr[i]);
        }

        rightArr[n] = arr[n];
        for(int i = n - 1; i >= 1 ; i--){
            rightArr[i] = Math.max(rightArr[i + 1], arr[i]);
        }

        // for(int i = 0 ; i <= n + 1; i++){
        //     System.out.print(leftArr[i] + " ");
        // }
        // System.out.println();

        // for(int i = 0 ; i <= n + 1; i++){
        //     System.out.print(rightArr[i] + " ");
        // }
        // System.out.println();

        for(int i = 0 ; i < q ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            bw.write(Math.max(leftArr[a - 1], rightArr[b + 1]) + "\n");
        }
        
        br.close();
        bw.close();
    }
}