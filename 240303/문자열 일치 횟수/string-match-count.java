import java.util.*;
import java.io.*;

public class Main {
    public static final int MAX_LENGTH = 100000;
    public static int[] f = new int[MAX_LENGTH + 1];
    public static String text = " ";
    public static int textLength = -1;
    public static StringBuilder sb = new StringBuilder();

    public static int isEqual(){
        String pattern = sb.toString();
        int patternLength = pattern.length();
        pattern = "#" + pattern;

        f[0] = -1;

        for(int i = 1 ; i <= patternLength ; i++){
            int j = f[i - 1];
            while(j >= 0 && pattern.charAt(i) != pattern.charAt(j + 1)){
                j = f[j];
            }

            f[i] = j + 1;
        }

        int ans = 0;
        int j = 0;
        for(int i = 1 ; i <= textLength ; i++){
            while(j >= 0 && text.charAt(i) != pattern.charAt(j + 1)){
                j = f[j];
            }

            j++;

            if(j == patternLength){
                j = f[j];
                ans++;
            }
        }

        return ans;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        text = String.valueOf(br.readLine());
        text += text.substring(0, text.length() - 1);
        textLength = text.length();
        text = "#" + text;

        sb.append(String.valueOf(br.readLine()));

        System.out.println(isEqual());  
    }
}