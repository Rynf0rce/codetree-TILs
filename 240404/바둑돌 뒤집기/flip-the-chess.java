import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        char[] inArr = String.valueOf(br.readLine()).toCharArray();
        char[] outArr = String.valueOf(br.readLine()).toCharArray();

        int black = 0;
        int white = 0;
        
        for(int i = 0 ; i < n ; i++){
            if(inArr[i] == outArr[i]){
                continue;
            }

            if(inArr[i] == 'B'){
                black++;
            }
            else{
                white++;
            }
        }

        int cnt = black + white;
        cnt -= Math.min(black, white);
        System.out.print(cnt);
        
    }
}