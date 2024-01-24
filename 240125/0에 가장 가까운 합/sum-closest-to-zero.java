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

        // for(int i = 0 ; i < n ; i++){
        //     System.out.print(arr[i] + " ");
        // }
        // System.out.println();

        int j = n - 1;
        long minVal = MAX_INT * 2;
        long curVal = 0;
        for(int i = 0 ; i < n ; i++){
            curVal = MAX_INT * 2;
            while(i < j){
                if(Math.abs(arr[i] + arr[j]) < curVal){
                    curVal = Math.abs(arr[i] + arr[j]);
                    if(i + 1 < j && Math.abs(arr[i + 1] + arr[j]) < curVal){
                        break;
                    }
                    else{
                        j--;
                    }
                }
                else{
                    break;
                }
            }

            if(minVal > curVal){
                minVal = curVal;
            }
        }

        bw.write(minVal + "");
        
        bw.close();
        br.close();
    }
}