import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] arr = String.valueOf(br.readLine()).toCharArray();
        long ans = 0;
        for(int i = arr.length - 1 ; i >= 0 ; i--){
            if(arr[i] == '1'){
                ans += Math.pow(2, arr.length - 1 - i);
            }
        }
        System.out.print(ans);
    }
}