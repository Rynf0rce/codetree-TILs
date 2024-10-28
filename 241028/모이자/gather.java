import java.util.*;
import java.io.*;

public class Main {
    public static final int RANGE = 100;
    public static final int INVALID = (int)1e9;
    public static int[] arr = new int[RANGE + 1];

    public static int abs (int input){
        if(input < 0){
            input *= -1;
        }
        return input;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 1 ; i <= n ; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int minVal = INVALID;
        for(int i = 1 ; i <= n ; i++){
            int distance = 0;
            for(int j = 1 ; j <= n ; j++){
                distance += abs(i - j) * arr[j];
            }
            minVal = Math.min(minVal, distance);
        }

        bw.write(minVal + "");
        bw.close();
    }
}