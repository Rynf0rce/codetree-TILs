import java.util.*;
import java.io.*;
public class Main {
    public static final int MAX_LENGTH = 100000;
    public static int[] arr = new int[MAX_LENGTH];
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0 ; i < n ; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr, 0, n);
        System.out.print(Math.max(arr[n - 1] * arr[n - 2] * arr[n - 3], arr[0] * arr[1] * arr[n - 1]));
    }
}