import java.util.*;
import java.io.*;
public class Main {
    public static final int MAX_LENGTH = 50;
    public static char[] arr = new char[MAX_LENGTH];
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0 ; i < n ; i++){
            arr[i] = st.nextToken().charAt(0);
        }

        for(int i = n - 1 ; i >= 0 ; i--){
            System.out.print(arr[i] + " ");
        }
    }
}