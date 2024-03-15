import java.util.*;
import java.io.*;


public class Main {
    public static final int MAX_LENGTH = 1000;
    public static int[] f = new int[MAX_LENGTH + 1];
    public static String str = " ";
    
    public static int cntTarget(String target){
        int strLength = str.length();
        int tarLength = target.length();

        String mdfString = "#" + str;
        String mdfTarget = "#" + target;

        f[0] = -1;

        for(int i = 1 ; i <= tarLength ; i++){
            int j = f[i - 1];

            while(j >= 0 && mdfTarget.charAt(j + 1) != mdfTarget.charAt(i)){
                j = f[j];
            }

            f[i] = j + 1;
        }

        int j = 0;
        int ans = 0;
        for(int i = 1 ; i <= strLength ; i++){
            while(j >= 0 && mdfTarget.charAt(j + 1) != mdfString.charAt(i)){
                
                j = f[j];
            }
            j++;
            if(j == tarLength){
                ans++;
                j = f[j];
            }
        }

        return ans;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        str = String.valueOf(br.readLine());
        System.out.print(cntTarget("KOI") + " " + cntTarget("IOI"));
    }
}