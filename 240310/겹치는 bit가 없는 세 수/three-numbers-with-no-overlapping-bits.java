import java.util.*;
import java.io.*;

public class Main {
    public static final int MAX_LENGTH = 500;
    public static long[] arr = new long[MAX_LENGTH];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0 ; i < n ; i++){
            arr[i] = Long.parseLong(st.nextToken());
        }
        
        long ans = 0;
        for(int i = 0 ; i < n - 2; i++){
            for(int j = i + 1 ; j < n - 1; j++){
                for(int k = j + 1 ; k < n ; k++){
                    if(arr[i] + arr[j] + arr[k] == (arr[i] | arr[j] | arr[k])){
                        ans = Math.max(ans, arr[i] + arr[j] + arr[k]);
                    }
                }
            }
        }
        System.out.print(ans);
    }
}

/*
import java.util.*;
import java.io.*;

public class Main {
    public static final int MAX_LENGTH = 500;
    public static long[] arr = new long[MAX_LENGTH];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0 ; i < n ; i++){
            arr[i] = Long.parseLong(st.nextToken());
        }
        
        long ans = 0;
        for(int i = 0 ; i < n - 2; i++){
            for(int j = i + 1 ; j < n - 1; j++){
                if( (arr[i] ^ arr[j]) != arr[i] + arr[j]){
                    continue;
                }
                for(int k = j + 1 ; k < n ; k++){
                    if( (arr[k] ^ arr[i]) == arr[k] + arr[i] && (arr[k] ^ arr[j]) == arr[k] + arr[j]){
                        ans = Math.max(ans, arr[i] + arr[j] + arr[k]);
                    }
                }
            }
        }
        System.out.print(ans);
    }
}
*/