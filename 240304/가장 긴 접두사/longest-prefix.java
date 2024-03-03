import java.util.*;
import java.io.*;

public class Main {
    public static final int MAX_LENGTH = 100000;
    public static int[] f = new int[MAX_LENGTH + 1];
    public static String text = " ";
    public static int textLength = -1;

    public static boolean satisfied(int length){
        StringBuilder sb = new StringBuilder();
        sb.append(text.substring(1, length + 1));
        String patten = sb.reverse().toString();
        int pattenLength = patten.length();
        patten = "#" + patten;

        f[0] = -1;
        for(int i = 1 ; i <= pattenLength ; i++){
            int j = f[i - 1];
            while(j >= 0 && patten.charAt(j + 1) != patten.charAt(i)){
                j = f[j];
            }
            f[i] = j + 1;
        }

        int j = 0;
        for(int i = 1 ; i <= textLength ; i++){
            while(j >= 0 && patten.charAt(j + 1) != text.charAt(i)){
                j = f[j];
            }
            j = j + 1;
            if(j == pattenLength){
                return true;
            }
        }

        return false;
    }



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        text = String.valueOf(br.readLine());
        textLength = text.length();
        
        int start = 1;
        int end = text.length();
        int ans = 0;

        text = "#" + text;

        while(start <= end){
            int mid = (end + start) / 2;
            if(satisfied(mid)){
                start = mid + 1;
                ans = Math.max(ans, mid);
            }
            else{
                end = mid - 1;
            }
        }
        System.out.print(ans);
    }
}