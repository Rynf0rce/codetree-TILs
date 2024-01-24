import java.util.*;
import java.io.*;
public class Main {
    public static final int MAX_LENGTH = 100000;
    public static final int MAX_INT = 1000000000;
    public static int[] arr = new int[MAX_LENGTH];
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0 ; i < n ; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr, 0, n);

        int j = n - 1;
        long minVal = MAX_INT * 2;
        for(int i = 0 ; i < n ; i++){
            while(i < j){
                // System.out.println(arr[i] + " " + arr[j]);
                if(Math.abs(arr[i] + arr[j]) <= minVal){
                    minVal = Math.abs(arr[i] + arr[j]);
                    j--;
                }
                else{
                    break;
                }
            }
        }

        bw.write(minVal + "");
        
        bw.close();
        br.close();
    }
}