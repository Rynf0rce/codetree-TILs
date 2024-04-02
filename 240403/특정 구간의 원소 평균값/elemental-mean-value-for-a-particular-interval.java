import java.util.*;
import java.io.*;
public class Main {
    public static final int MAX_LENGTH = 100;
    public static int[] arr = new int[MAX_LENGTH + 1];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 1 ; i <= n ; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int cnt = 0;
        for(int i = 1 ; i <= n ; i++){
            for(int j = i ; j <= n ; j++){
                double sum = 0;
                for(int k = i ; k <= j ; k++){
                    sum += arr[k];
                }

                for(int k = i ; k <= j ; k++){
                    if(sum / (j - i + 1) == arr[k]){
                        cnt++;
                        break;
                    }
                }
            }
        }
        System.out.print(cnt);
    }
}