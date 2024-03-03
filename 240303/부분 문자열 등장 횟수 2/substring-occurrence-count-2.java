import java.util.*;
import java.io.*;

public class Main {
    public static final int MAX_LENGTH = 100000;
    public static int[] f = new int[MAX_LENGTH + 1];
    public static String text = " ";
    public static int textLength = -1;

    public static int cntFnc(String pattern){
        int ans = 0;
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
                ans++;
                j = f[j];
            }
        }
        return ans;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        text = String.valueOf(st.nextToken());
        textLength = text.length();
        text = "#" + text;
        
        int q = Integer.parseInt(st.nextToken());
        for(int i = 0 ; i < q ; i++){
            String pattern = String.valueOf(br.readLine());
            System.out.println(cntFnc(pattern));
        }
    }
}