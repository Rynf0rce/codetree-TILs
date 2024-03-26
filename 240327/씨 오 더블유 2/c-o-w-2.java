import java.util.*;
import java.io.*;

public class Main {
    public static final int MAX_LENGTH = 100;
    public static int[] oArr = new int[MAX_LENGTH + 1];
    public static int[] wArr = new int[MAX_LENGTH + 1];
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        char[] arr = String.valueOf(br.readLine()).toCharArray();
        int ans = 0;
        
        for(int i = 0 ; i < n - 2 ; i++){
            if(arr[i] != 'C'){
                continue;
            }
            for(int j = i + 1 ; j < n - 1; j++){
                if(arr[j] != 'O'){
                    continue;
                }
                for(int k = j + 1 ; k < n ; k++){
                    if(arr[k] != 'W'){
                        continue;
                    }
                    ans++;
                }
            }
        }
        System.out.print(ans);
    }
}