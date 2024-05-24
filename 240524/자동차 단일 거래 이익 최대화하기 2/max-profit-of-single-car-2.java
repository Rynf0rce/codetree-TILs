import java.util.*;
import java.io.*;
public class Main {
    public static int MAX_LENGTH = 100000;
    public static double[] arr = new double[MAX_LENGTH + 1];
    public static double[] RightMax = new double[MAX_LENGTH + 1];
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 1 ; i <= n ; i++){
            arr[i] = Double.parseDouble(st.nextToken());
        }
        for(int i = n; i > 0 ; i--){
            RightMax[i] = Math.max(RightMax[i + 1], arr[i]);
        }
        double ans = 0;
        for(int i = 1 ; i < n ; i++){
            if(arr[i] > RightMax[i]){
                continue;
            }
            if(ans < RightMax[i] - arr[i]){
                ans = RightMax[i] - arr[i];
            }
        }
        System.out.printf("%.0f", ans);
    }
}