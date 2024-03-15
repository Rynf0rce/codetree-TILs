import java.util.*;
import java.io.*;

public class Main {
    public static int arr[] = new int[(int)('z' - 'a') + 1];
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0 ; i < n ; i++){
            char c = String.valueOf(st.nextToken()).charAt(0);
            if(c < 'a' || c > 'z'){
                break;
            }
            arr[(int)(c - 'a')]++;
        }

        for(int i = 0 ; i < arr.length ; i++){
            if(arr[i] == 0){
                continue;
            }
            System.out.println((char)(i + 'a') + " : " + arr[i]);
        }
    }
}