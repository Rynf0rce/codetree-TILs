import java.util.*;
import java.io.*;

public class Main {
    public static final int MAX_ELEMENTS = 100000;
    public static int[] arr =  new int[MAX_ELEMENTS];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0 ; i < n ; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int sum = 0;
        int j = -1;
        int minLength = MAX_ELEMENTS + 1;
        for(int i = 0 ; i < n ; i++){
            while(j + 1 < n){
                if(sum >= s){
                    break;
                }
                sum += arr[j + 1];
                j++;
            }

            if(sum >= s){
                minLength = Math.min(minLength, j - i + 1);
            }
            sum -= arr[i];
        }

        bw.write( (minLength == MAX_ELEMENTS + 1 ? -1 : minLength) + "");

        br.close();
        bw.close();
    }
}