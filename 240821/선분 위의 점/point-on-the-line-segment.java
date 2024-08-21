import java.util.*;
import java.io.*;

public class Main {
    public static final int MAX_LENGTH = 100000;
    public static int[] arr = new int[MAX_LENGTH];
    public static int n;

    public static int lowerBound(int target){
        int start = 0;
        int end = n - 1;
        int output = n;
        while(start <= end){
            int mid = (start + end) / 2;
            if(arr[mid] >= target){
                end = mid - 1;
                output = Math.min(output, mid);
            }
            else{
                start = mid + 1;
            }
        }
        return output;
    }

    public static int upperBound(int target){
        int start = 0;
        int end = n - 1;
        int output = n;
        while(start <= end){
            int mid = (start + end) / 2;
            if(arr[mid] > target){
                end = mid - 1;
                output = Math.min(output, mid);
            }
            else{
                start = mid + 1;
            }
        }
        return output;
    }

    public static int inPoint(int x1, int x2){
        return upperBound(x2) - lowerBound(x1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0 ; i < n ; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr, 0, n);

        for(int i = 0 ; i < m ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int x1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            bw.write(inPoint(x1, x2) + "\n");
        }
        
        br.close();
        bw.close();
    }
}