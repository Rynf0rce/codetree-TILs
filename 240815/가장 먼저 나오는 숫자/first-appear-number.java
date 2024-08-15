import java.util.*;
import java.io.*;

public class Main {
    public static final int MAX_LENGTH = 100000;
    public static int[] arr = new int[MAX_LENGTH];

    public static int lowerBound(int target, int size){
        int start = 0;
        int end = size - 1;
        int output = size;
        while(start <= end){
            int mid = (end + start) / 2;
            if(arr[mid] >= target){
                end = mid - 1;
                if(arr[mid] == target){
                    output = Math.min(output, mid);
                }
            }
            else{
                start = mid + 1;
            }
        }

        return output == size ? -1 : output + 1;
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

        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0 ; i < m ; i++){
            int num = Integer.parseInt(st.nextToken());
            bw.write(lowerBound(num, n) + "\n");
        }

        br.close();
        bw.close();
    }
}