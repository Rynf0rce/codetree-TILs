import java.util.*;
import java.io.*;

public class Main {
    public static final int MAX_WORD = 10;
    public static String[] arr = new String[MAX_WORD];

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int totalLength = 0;
        for(int i = 0 ; i < n ; i++){
            arr[i] = String.valueOf(br.readLine());
            totalLength += arr[i].length();
        }
        
        int base = (m - totalLength) / (n - 1);
        int remain = m - totalLength - base * (n - 1);

        for(int i = 0 ; i < n - 1 ; i++){
            System.out.print(arr[i]);
            for(int j = 0 ; j < base ; j++){
                System.out.print("_");
            }

            if(remain > 0 && (n - 1 - i <= remain || arr[i + 1].charAt(0) >= 'a')){
                remain--;
                System.out.print("_");
            }
        }
        System.out.print(arr[n - 1]);
    }
}