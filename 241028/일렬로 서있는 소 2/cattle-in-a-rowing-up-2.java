import java.util.*;
import java.io.*;
public class Main {
    public static final int MAX_COW = 100;
    public static int[] arr = new int[MAX_COW + 1];
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0 ; i < n ; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int cnt = 0;
        for(int i = 0 ; i < n  ; i++){
            for(int j = i + 1 ; j < n ; j++){
                for(int k = j + 1 ; k < n ; k++){
                    if(arr[i] <= arr[j] && arr[j] <= arr[k]){
                        cnt++;
                    }
                }
            }
        }
        System.out.print(cnt);
    }
}