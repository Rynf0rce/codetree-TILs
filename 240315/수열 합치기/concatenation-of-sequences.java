import java.util.*;
import java.io.*;
public class Main {
    public static final int MAX_LENGTH = 100000;
    public static int[] A = new int[MAX_LENGTH];
    public static int[] B = new int[MAX_LENGTH];
    public static int[] merge = new int[MAX_LENGTH * 2];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0 ; i < n ; i++){
            A[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0 ; i < m ; i++){
            B[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0 ; i < n ; i++){
            merge[i] = A[i];
        }

        for(int i = 0 ; i < m ; i++){
            merge[i + n] = B[i];
        }

        Arrays.sort(merge, 0, n + m);

        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < n + m ; i++){
            sb.append(merge[i] + " ");
        }
        System.out.print(sb.toString());
    }
}