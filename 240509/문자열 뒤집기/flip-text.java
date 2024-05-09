import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] arr = String.valueOf(br.readLine()).toCharArray();
        int siteZero = 0;
        int siteOne = 0;

        if(arr[0] == '1'){
            siteOne++;
        }
        else{
            siteZero++;
        }

        for(int i = 0 ; i < arr.length - 1; i++){
            if(arr[i] == '1' && arr[i] != arr[i + 1]){
                siteZero++;
            }
            else if(arr[i] == '0' && arr[i] != arr[i + 1]){
                siteOne++;
            }
            // System.out.println(siteZero + " " + siteOne);
        }
        System.out.print(Math.min(siteOne, siteZero));
    }
}