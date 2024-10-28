import java.util.*;
import java.io.*;

public class Main {
    public static final int MAX_LENGTH = 100;
    public static int[] left = new int[MAX_LENGTH + 1];
    public static int[] right = new int[MAX_LENGTH + 1];
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String str = " " + br.readLine() + " ";
        for(int i = 1 ; i < str.length() ; i++){
            left[i] = left[i - 1];
            if(str.charAt(i) == 'C'){
                left[i]++;
            }
        }

        for(int i = str.length() - 2 ; i > 0 ; i--){
            right[i - 1] = right[i];
            if(str.charAt(i) == 'W'){
                right[i - 1]++;
            }
        }

        int ans = 0;
        for(int i = 1 ; i < str.length() - 1 ; i++){
            if(str.charAt(i) != 'O'){
                continue;
            }
            ans += left[i] * right[i];
        }
        System.out.print(ans);
    }
}