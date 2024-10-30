import java.util.*;
import java.io.*;

public class Main {
    public static final int MAX_LENGTH = 100;
    public static int[] left = new int[MAX_LENGTH];
    public static int[] right = new int[MAX_LENGTH];
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st;
        for(int i = 0 ; i < n ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            left[i] = Integer.parseInt(st.nextToken());
            right[i] = Integer.parseInt(st.nextToken());
        }

        int val1 = 0;
        int val2 = 0;
        for(int i = 0 ; i < n ; i++){
            if(left[i] > right[i] || (left[i] == 3 && right[i] == 1)){
                val1++;
            }

            if(left[i] < right[i] || left[i] == 1 && right[i] == 3){
                val2++;
            }
        }
        System.out.print(Math.max(val1, val2));
    }
}