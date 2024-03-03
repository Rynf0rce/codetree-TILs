import java.util.*;
import java.io.*;

public class Main {
    public static final int MAX_LENGTH = 100000;
    public static int[] f = new int[MAX_LENGTH + 1];
    public static String text = " ";
    public static int textLength = -1;
    public static StringBuilder sb = new StringBuilder();
    public static HashMap<String, Integer> ansMap = new HashMap<>();

    public static void shift(){
        int size = sb.length();
        sb.append(sb.substring(0, size -1));
        sb.delete(0, size - 1);
    }

    public static boolean isEqual(){
        String pattern = sb.toString();
        int patternLength = pattern.length();
        pattern = "#" + pattern;

        for(int i = 0 ; i <= patternLength ; i++){
            f[i] = 0;
        }

        f[0] = -1;

        for(int i = 1 ; i <= patternLength ; i++){
            int j = f[i - 1];
            while(j >= 0 && pattern.charAt(i) != pattern.charAt(j + 1)){
                j = f[j];
            }

            f[i] = j + 1;
        }

        int j = 0;
        for(int i = 1 ; i <= textLength ; i++){
            while(j >= 0 && text.charAt(i) != pattern.charAt(j + 1)){
                j = f[j];
            }

            j++;

            if(j == patternLength){
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        text = String.valueOf(br.readLine());
        textLength = text.length();
        // text = "#" + text;

        sb.append(String.valueOf(br.readLine()));

        int ans = 0;
        for(int i = 0 ; i < n ; i++){
            shift();
            ansMap.put(sb.toString(), ansMap.getOrDefault(sb.toString(), 0) + 1);
        }

        System.out.print(ansMap.getOrDefault(text, 0));
        
    }
}