import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] arr = String.valueOf(br.readLine()).toCharArray();
        char[] target = String.valueOf(br.readLine()).toCharArray();
        int j = 0;
        int ans = 1;
        boolean flag = false;
        while(j < target.length){
            for(int i = 0 ; i < arr.length ; i++){
                if(target[j] == arr[i]){
                    j++;
                }

                if(j >= target.length){
                    flag = true;
                    break;
                }
            }

            if(flag){
                break;
            }
            ans++;
        }
        System.out.print(ans);
    }
}