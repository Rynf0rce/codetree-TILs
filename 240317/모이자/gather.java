import java.util.*;
import java.io.*;

public class Main {
    public static final int MAX_LENGTH = 100;
    public static final int MAX_INT = 10000;
    public static int[] arr = new int[MAX_LENGTH];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0 ; i < n ; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int minVal = MAX_INT;
        
        for(int i = 0 ; i < n ; i++){
            int dist = 0;
            for(int j = 0 ; j < n ; j++){
                dist += Math.abs(j - i) * arr[j];
            }
            minVal = Math.min(minVal, dist);
        }
        System.out.print(minVal);
    }
}