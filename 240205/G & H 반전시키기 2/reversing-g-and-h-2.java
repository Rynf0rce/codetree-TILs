import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        char[] inArr = br.readLine().toCharArray();
        char[] targetArr = br.readLine().toCharArray();

        int cnt = 0;
        boolean triger = false;
        for(int i = n - 1; i >= 0 ; i--){
            if( (targetArr[i] != inArr[i] && !triger) || (targetArr[i] == inArr[i]) && triger ){
                cnt++;
                if(triger){
                    triger = false;
                }
                else{
                    triger = true;
                }
            }
        }

        System.out.print(cnt);
    }
}