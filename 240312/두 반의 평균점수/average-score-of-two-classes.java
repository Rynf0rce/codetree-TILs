import java.util.*;
import java.io.*;

public class Main {
    public static final int MAX_LENGTH = 10;
    public static int[] arr = new int[MAX_LENGTH + 1];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 1 ; i <= n ; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine(), " ");
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        System.out.printf("%.1f", (float)(arr[a] + arr[b]) / 2);
    }
}