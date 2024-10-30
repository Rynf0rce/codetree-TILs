import java.util.*;
import java.io.*;

public class Main {
    public static final int ALPHABET = 26;
    public static char[] arr = new char[ALPHABET];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0 ; i < n ; i++){
            arr[i] = st.nextToken().charAt(0);
        }

        char target = 'A';
        int cnt = 0;
        for(int i = 0 ; i < n ; i++){
            for(int j = i ; j < n ; j++){
                if(arr[j] == target){
                    cnt += (j - i);
                }
            }
            target++;
        }
        System.out.print(cnt);
    }
}