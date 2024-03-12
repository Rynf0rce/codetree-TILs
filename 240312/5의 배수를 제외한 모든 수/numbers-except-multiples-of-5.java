import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int cnt = 0;
        int sum = 0;

        if(a > b){
            int temp = a;
            a = b;
            b = temp;
        }
        
        for(int i = a ; i <= b ; i++){
            if(i % 5 == 0){
                continue;
            }
            cnt++;
            sum += i;
        }
        double avg = sum / cnt;
        System.out.printf("%d %.1f", sum, avg);
    }
}