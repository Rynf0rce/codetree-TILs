import java.util.*;
import java.io.*;

public class Main {
    public static final int MAX_INT = 100000;
    public static double[] arr = new double[MAX_INT];

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0 ; i < n ; i++){
            arr[i] = Double.parseDouble(st.nextToken());
        }

        Arrays.sort(arr, 0, n);
        double ans = arr[n - 1];
        for(int i = 0 ; i < n - 1 ; i++){
            ans += arr[i] / 2;
        }
        System.out.print(ans);
    }
}