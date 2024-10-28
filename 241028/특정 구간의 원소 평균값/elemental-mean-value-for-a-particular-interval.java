import java.util.*;
import java.io.*;

public class Main {
    public static final int MAX_LENGTH = 100;
    public static double[] arr = new double[MAX_LENGTH];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0 ; i < N ; i++){
            arr[i] = Double.parseDouble(st.nextToken());
        }
        
        int ans = 0;
        for(int i = 0 ; i < N ; i++){
            for(int j = i ; j < N ; j++){
                double sum = 0;
                for(int k = i ; k <= j ; k++){
                    sum += arr[k];
                }

                for(int k = i ; k <= j ; k++){
                    if(sum / (j - i + 1) == arr[k]){
                        // System.out.println(i + " " + j);
                        ans++;
                        break;
                    }
                }
                
            }
        }
        System.out.print(ans);
    }
}