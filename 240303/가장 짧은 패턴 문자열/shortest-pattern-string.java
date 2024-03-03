import java.util.*;
import java.io.*;

public class Main {
    public static final int MAX_LENGTH = 100000;
    public static int[] f = new int[MAX_LENGTH  +1];
    public static String str = " ";
    public static int strLength = -1;

    public static boolean satisfied(int length){
        StringBuilder sb = new StringBuilder();
        while(sb.length() < str.length()){
            sb.append(str.substring(1, length + 1));
        }

        String text = sb.toString();
        int textLength = text.length();
        text = "#" + text;

        int j = 0;
        for(int i = 1 ; i <= textLength ; i++){
            while(j >= 0 && str.charAt(j + 1) != text.charAt(i)){
                j = f[j];
            }

            j++;
            if(j == strLength){
                return true;
            }
        }

        return false;
    }



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        str = String.valueOf(br.readLine());
        strLength = str.length();
        str = "#" + str;

        f[0] = -1;
        for(int i = 1 ; i <= strLength ; i++){
            int j = f[i - 1];
            while(j >= 0 && str.charAt(i) != str.charAt(j + 1)){
                j = f[j];
            }

            f[i] = j + 1;
        }

        // for(int i = 0 ; i <= strLength ; i++){
        //     System.out.print(f[i] + " ");
        // }

        // System.out.println();

        int start = 1;
        int end = str.length();
        int ans = MAX_LENGTH;
        while(start <= end){
            int mid = (end + start) / 2;
            if(satisfied(mid)){
                end = mid - 1;
                ans = Math.min(ans, mid);
            }
            else{
                start = start + 1;
            }
        }

        System.out.print(ans);
    }
}