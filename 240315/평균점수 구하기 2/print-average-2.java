import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        double sum = 0;
        for(int i = 0 ; i < n ; i++){
            sum += Double.parseDouble(st.nextToken());
        }
        System.out.printf("%.1f", sum / n);
    }
}