import java.util.*;
import java.io.*;

public class Main {
    public static String S = " ";
    public static boolean isTarget(String target){
        for(int i = 0 ; i < S.length() - target.length() + 1; i++){
            boolean ans = true;
            for(int j = 0 ; j < target.length() ; j++){
                if(target.charAt(j) != S.charAt(i + j)){
                    ans = false;
                }
            }

            if(ans){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        S = String.valueOf(br.readLine());
        System.out.print(isTarget("ee") ? "YES" : "NO");
        System.out.print(" ");
        System.out.print(isTarget("ea") ? "YES" : "NO");
    }
}