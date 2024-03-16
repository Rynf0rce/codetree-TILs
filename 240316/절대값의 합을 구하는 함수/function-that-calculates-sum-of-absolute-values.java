import java.util.*;
import java.io.*;

public class Main {
    public static int abs(int num){
        if(num < 0){
            return num * -1;
        }
        return num;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int sum = 0;
        for(int i = 0 ; i < n ; i++){
            sum += abs(Integer.parseInt(st.nextToken()));
        }
        System.out.print(sum);
    }
}