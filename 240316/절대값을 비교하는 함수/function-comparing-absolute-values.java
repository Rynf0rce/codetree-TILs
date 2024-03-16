import java.util.*;
import java.io.*;

public class Main {
    public static int findAns(int a, int b){
        if(a < 0){
            a *= -1;
        }

        if(b < 0){
            b *= -1;
        }

        if(a > b){
            return a;
        }
        return b;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for(int i = 0 ; i < n ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            System.out.println(findAns(a, b));
        }
    }
}