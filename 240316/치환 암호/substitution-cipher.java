import java.util.*;
import java.io.*;

public class Main {
    public static char[] encryption = new char[26];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] arr = String.valueOf(br.readLine()).toCharArray();
        String str = String.valueOf(br.readLine());

        for(int i = 0 ; i < str.length() ; i++){
            encryption[str.charAt(i) - 'a'] = (char)('a' + i);
        }

        for(int i = 0 ; i < arr.length ; i++){
            if(arr[i] == ' '){
                System.out.print(" ");
            }

            else{
                System.out.print(encryption[arr[i] - 'a']);
            }
        }
    }
}