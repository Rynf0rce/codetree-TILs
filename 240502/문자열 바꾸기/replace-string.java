import java.util.*;
import java.io.*;

public class Main {
    public static final int ALPHA_NUM = 26;
    public static int[] originNum = new int[ALPHA_NUM];
    public static int[] targetNum = new int[ALPHA_NUM];
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String origin = String.valueOf(br.readLine());
        String target = String.valueOf(br.readLine());
        int ans = origin.length() - 1;
        boolean flag = true;
        for(int i = origin.length() - 1 ; i >= 0 ; i--){
            if(flag && origin.charAt(i) == target.charAt(i)){
                ans--;
            }
            else{
                flag = false;
            }
            originNum[origin.charAt(i) - 'A']++;
            targetNum[target.charAt(i) - 'A']++;
        }

        boolean ansFlag = true;
        for(int i = 0 ; i < ALPHA_NUM ; i++){
            if(originNum[i] != targetNum[i]){
                ansFlag = false;
                break;
            }
        }

        System.out.print(ansFlag ? ans : -1);
    }
}