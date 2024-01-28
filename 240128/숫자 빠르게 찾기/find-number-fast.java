import java.util.*;
import java.io.*;

public class Main {
    public static final int MAX_LENGTH = 100000;
    public static int[] arr = new int[MAX_LENGTH];

    public static int binarySearch(int num, int size){
        // System.out.println(num + " " + size);
        int start = 0;
        int end = size - 1;

        while(start <= end){
            int mid = (end + start) / 2;
            // System.out.println("mid : " + mid + " " + arr[mid]);
            if(arr[mid] == num){
                return mid + 1;
            }
            else if(arr[mid] > num){
                end = mid - 1;
            }
            else{
                start = mid + 1;
            }
        }
        return -1;
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
            bw.write(binarySearch(num, n) + "\n");
        }

        br.close();
        bw.close();
    }
}