import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        char[] inArr = br.readLine().toCharArray();
        char[] targetArr = br.readLine().toCharArray();

        boolean triger = false;
        int cnt = 0;
        for(int i = 0 ; i < N ; i++){
            if(inArr[i] == targetArr[i]){
                triger = false;
            }
            else{
                if(!triger){
                    cnt++;
                    triger = true;
                }
            }
        }
        System.out.print(cnt);
    }
}