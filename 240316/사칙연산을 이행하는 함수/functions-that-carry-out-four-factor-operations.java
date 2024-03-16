import java.util.*;
import java.io.*;

public class Main {
    public static int calculator(String left, String oper, String right){
        int a = Integer.valueOf(left);
        char c = oper.charAt(0);
        int b = Integer.valueOf(right);
        switch(c){
            case '+' :
                return a + b;
            case '-' :
                return a - b;
            case '*' :
                return a * b;
            case '/' :
                return a / b;
        }

        return 0;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] arr = br.readLine().split(" ");
        System.out.printf("%s %s %s = %d", arr[0], arr[1], arr[2], calculator(arr[0], arr[1], arr[2]));
    }
}