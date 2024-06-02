import java.util.*;
import java.io.*;

public class Main {
    public static final int MAX_LENGTH = 100000;
    public static int[] f = new int[MAX_LENGTH + 1];

    public static String text = " ";
    public static String pattern = " ";
    public static int patternLength = -1;

    public static StringBuilder sb = new StringBuilder();

    public static void findAns(){
        boolean ans = true;

        while(ans){
            ans = false;
            sb.setLength(0);

            int j = 0;
            int pivot = 1;
            for(int i = 1 ; i < text.length() ; i++){
                while(j >= 0 && text.charAt(i) != pattern.charAt(j + 1)){
                    j = f[j];
                }
                j++;
                if(j == patternLength){
                    ans = true;
                    sb.append(text.substring(pivot, i - j + 1));
                    j = 0;
                    pivot = i + 1;
                }
            }

            sb.append(text.substring(pivot));
            text = "#" + sb.toString();
        }

        System.out.print(sb.toString());
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        text = "#" + String.valueOf(br.readLine());
        pattern = "#" + String.valueOf(br.readLine());
        patternLength = pattern.length() - 1;

        f[0] = -1;
        for(int i = 1 ; i <= patternLength ; i++){
            int j = f[i - 1];
            while(j >= 0 && pattern.charAt(j + 1) != pattern.charAt(i)){
                j = f[j];
            }
            f[i] = j + 1;
        }

        findAns();
    }
}