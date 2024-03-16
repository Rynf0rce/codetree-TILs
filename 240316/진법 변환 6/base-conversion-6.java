import java.util.*;
import java.io.*;

public class Main {
    public static Stack<Character> s = new Stack<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        char[] arr = String.valueOf(st.nextToken()).toCharArray();
        int m = Integer.parseInt(st.nextToken());

        long num = 0;
        for(int i = arr.length -1 ; i >= 0 ; i--){
            int val = 0;
            if(arr[i] >= 'a'){
                val = (arr[i] -'a') + 10;
            }
            else{
                val = arr[i] - '0';
            }

            num += val * (int)Math.pow(n, (arr.length -1) - i);
        }
        

        while(num > 0){
            long c = num % m;
            if(c >= 10){
                s.add((char)('a' + c - 10 ));
            }
            else{
                s.add(Long.toString(c).charAt(0));
            }
            num /= m;
        }

        while(!s.isEmpty()){
            System.out.print(s.pop());
        }
    }
}