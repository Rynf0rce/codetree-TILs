import java.util.*;
import java.io.*;

public class Main {
    public static final int MAX_NUM = 20;
    public static int[] arr = new int[MAX_NUM];

    public static boolean isCarry(int a, int b, int c){
        while(!(a == 0 && b == 0 && c == 0)){
            if(a % 10 + b % 10 + c % 10  >= 10){
                return true;
            }

            a /= 10;
            b /= 10;
            c /= 10;
        }
        return false;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for(int i = 0 ; i < n ; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        int ans = -1;
        for(int i = 0 ; i < n - 2 ; i++){
            for(int j = i + 1; j < n - 1 ; j++){
                for(int k = j + 1 ; k < n ; k++){
                    if(!isCarry(arr[i], arr[j], arr[k])){
                        ans = Math.max(ans, arr[i] + arr[j] + arr[k]);
                    }
                }
            }
        }
        System.out.println(ans);

    }
}