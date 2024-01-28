import java.util.*;
import java.io.*;

public class Main {
    public static final int MAX_LENGTH = 100000;
    public static int[] arr = new int[MAX_LENGTH];

    public static int cntNum(int target, int size){
        int start = 0;
        int end = size - 1;
        int lowerBound = size;
        while(start <= end){
            int mid = (end + start) / 2;
            if(arr[mid] >= target){
                end = mid - 1;
                lowerBound = Math.min(lowerBound, mid);
            }
            else{
                start = mid + 1;
            }
        }

        start = 0;
        end = size - 1;
        int upperBound = size;
        while(start <= end){
            int mid = (end + start) / 2;
            if(arr[mid] > target){
                end = mid - 1;
                upperBound = Math.min(upperBound, mid);
            }
            else{
                start = mid + 1;
            }
        }

        return upperBound - lowerBound;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0 ; i < n ; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0 ; i < m ; i++){
            int num = Integer.parseInt(br.readLine());
            bw.write(cntNum(num, n) + "\n");
        }

        br.close();
        bw.close();
    }
}