import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        char[] inArr = br.readLine().toCharArray();
        char[] targetArr = br.readLine().toCharArray();

        int cnt = 0;
        for(int i = n - 1; i >= 0 ; i--){
            if(targetArr[i] != inArr[i]){
                for(int j = i ; j >= 0 ; j--){
                    if(inArr[j] == 'H'){
                        inArr[j] = 'G';
                    }
                    else{
                        inArr[j] = 'H';
                    }
                }
                cnt++;
            }
        }

        System.out.print(cnt);
    }
}