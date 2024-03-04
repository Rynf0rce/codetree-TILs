import java.util.*;
import java.io.*;

public class Main {
    public static final int MAX_LENGTH = 100000;
    public static int f[] = new int[MAX_LENGTH + 1];
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String text = "#" + String.valueOf(br.readLine());
        String pattern = "#" + String.valueOf(br.readLine());

        f[0] = -1;
        for(int i = 1 ; i < pattern.length() ; i++){
            int j = f[i - 1];
            while(j >= 0 && pattern.charAt(i) != pattern.charAt(j + 1)){
                j = f[j];
            }

            f[i] = j + 1;
        }
        
        int j = 0;
        int ans = 0;
        for(int i = 1 ; i < text.length() ; i++){
            while(j >= 0 && pattern.charAt(j + 1) != text.charAt(i)){
                j = f[j];
            }

            j++;
            if(j == pattern.length() - 1){
                ans++;
                j = 0;
            }
        }

        System.out.println(ans);
    }
}