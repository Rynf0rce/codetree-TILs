import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        double sum = 0;
        for(int i = 1 ; i <= n ; i++){
            int num = Integer.parseInt(st.nextToken());
            sum += num;
            if(num >= 100){
                System.out.println((int)sum);
                System.out.printf("%.1f\n", sum / i);
            }
        }
    }
}