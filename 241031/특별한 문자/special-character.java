import java.util.*;
import java.io.*;

public class Main {
    public static final int ALPHABET = 26;
    public static int[] arr = new int[ALPHABET];
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        for(int i = 0 ; i < str.length() ; i++){
            arr[str.charAt(i) - 'a']++;
        }

        for(int i = 0 ; i < str.length() ; i++){
            if(arr[str.charAt(i) - 'a'] == 1){
                System.out.print(str.charAt(i));
                System.exit(0);
            }
        }
        System.out.print("None");
    }
}