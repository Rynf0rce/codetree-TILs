import java.util.*;
import java.io.*;
public class Main {
    public static final int MAX_LENGTH = 100;
    public static int[] preArr = new int[MAX_LENGTH + 1];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] arr = String.valueOf(br.readLine()).toCharArray();
        
        boolean triger = false;
        for(int i = arr.length - 1 ; i >= 0 ; i--){
            if(arr[i] == ')'){
                if(triger){
                    preArr[i]++;
                }
                else{
                    triger = true;
                }
            }
            else{
                triger = false;
            }
            preArr[i] += preArr[i + 1];
        }

        triger = false;
        int ans = 0;
        for(int i = 0 ; i < arr.length ; i++){
            if(arr[i] == '('){
                if(triger){
                    ans += preArr[i + 1];
                }
                else{
                    triger = true;
                }
            }
            else{
                triger = false;
            }
        }
        System.out.print(ans);
    }
}