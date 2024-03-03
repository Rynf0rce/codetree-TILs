import java.util.*;
import java.io.*;

public class Main {
    public static final int MAX_LENGTH = 100000;
    public static int[] f = new int[MAX_LENGTH  +1];
    public static String str = " ";
    public static int strLength = -1;

    public static boolean satisfied(int length){
        String text = str.substring(1, length + 1);
        int textLength = text.length();
        text = "#" + text;

        f[0] = -1;
        for(int i = 1 ; i <= textLength ; i++){
            int j = f[i - 1];
            while(j >= 0 && str.charAt(i) != str.charAt(j + 1)){
                j = f[j];
            }

            f[i] = j + 1;
        }

        // System.out.println(str + " " + text);
        // for(int i = 0 ; i <= textLength ; i++){
        //     System.out.print(f[i] + " ");
        // }
        // System.out.println();

        

        int j = 0;
        for(int i = 1 ; i <= strLength ; i++){
            while(j >= 0 && text.charAt(j + 1) != str.charAt(i)){
                return false;
            }

            j++;
            if(j == textLength){
                j = f[j];
            }
        }
        return true;
    }



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        str = String.valueOf(br.readLine());
        strLength = str.length();
        str = "#" + str;

        // satisfied(3);

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