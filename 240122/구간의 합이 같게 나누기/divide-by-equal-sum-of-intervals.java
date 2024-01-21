import java.util.*;
import java.io.*;

public class Main {
    public static final int MAX_LENGTH = 100000;
    public static final long[] arr = new long[MAX_LENGTH];

    public static long[] leftArr = new long[MAX_LENGTH];
    public static long[] rightArr = new long[MAX_LENGTH];

    public static int[] conLeftArr = new int[MAX_LENGTH];
    public static int[] conRightArr = new int[MAX_LENGTH];

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());

        int idx = 0;
        long sum = 0;

        st = new StringTokenizer(br.readLine(), " ");
        while(st.hasMoreTokens()){
            int num = Integer.parseInt(st.nextToken());
            sum += num;
            arr[idx++] = num;
        }

        leftArr[0] = arr[0];
        int cnt = 0;
        if(arr[0] == sum / 4){
            cnt++;
            conLeftArr[0] = cnt;
        }

        for(int i = 1 ; i < n ; i++){
            leftArr[i] = arr[i] + leftArr[i - 1];
            conLeftArr[i] = cnt;

            if(leftArr[i] == sum / 4){
                cnt++;
                conLeftArr[i] = cnt;
            }
        }

        rightArr[n - 1] = arr[n - 1];
        cnt = 0;
        if(arr[n - 1] == sum / 4){
            cnt++;
            conRightArr[n - 1] = cnt;
        }

        for(int i = n - 2; i >= 0 ; i--){
            rightArr[i] = rightArr[i + 1] + arr[i];
            conRightArr[i] = cnt;

            if(rightArr[i] == sum / 4){
                cnt++;
                conRightArr[i] = cnt;
            }
        }

        long output = 0;
        for(int i = 1 ; i < n - 2 ; i++){
            if(leftArr[i] == sum / 2){
                output += conLeftArr[i - 1] * conRightArr[i + 2];
            }
        }

        bw.write(output + "");

        br.close();
        bw.close();
    }
}