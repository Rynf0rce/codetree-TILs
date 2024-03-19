import java.util.*;
import java.io.*;

public class Main {
    public static final int MAX_LENGTH = 100;
    public static int[] order = new int[MAX_LENGTH];
    public static int[] arr = new int[MAX_LENGTH];
    public static int[] temp = new int[MAX_LENGTH];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0 ; i < n ; i++){
            order[Integer.parseInt(st.nextToken()) - 1] = i;
        }

        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0  ; i < n ; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int cnt = 3;
        while(cnt-- > 0){
            for(int i = 0 ; i < n ; i++){
                temp[i] = arr[i];
            }

            for(int i = 0 ; i < n ; i++){
                arr[order[i]] = temp[i];
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < n ; i++){
            sb.append(arr[i] + "\n");
        }
        System.out.print(sb.toString());
    }
}