import java.util.*;
import java.io.*;

public class Main {
    public static char[] a = new char[1];
    public static char[] b = new char[1];

    public static long findInt(int idx){
        if(a[idx] == '1'){
            a[idx] = '0';
        }
        else{
            a[idx] = '1';
        }

        long num = 0;
        for(int i = 0 ; i < a.length ; i++){
            num += (a[i] - '0') * Math.pow(2, a.length - 1 - i);
        }
        long ans = num;

        Stack<Character> s = new Stack<>();
        for(int i = 0 ; i < b.length ; i++){
            s.add((char)(num % 3 + '0'));
            num /= 3;
        }

        int curIdx = b.length - 1;
        int cnt = 0;
        while(!s.isEmpty()){
            if(b[curIdx--] != s.peek()){
                cnt++;
            }
            s.pop();
        }

        if(a[idx] == '1'){
            a[idx] = '0';
        }
        else{
            a[idx] = '1';
        }

        if(cnt >= 2){
            return -1;
        }

        return ans;
    }


    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        a = String.valueOf(br.readLine()).toCharArray();
        b = String.valueOf(br.readLine()).toCharArray();
        for(int i = 0 ; i < a.length ; i++){
            long num = findInt(i);
            if(num >= 0){
                System.out.print(num);
                break;
            }
        }
    }
}