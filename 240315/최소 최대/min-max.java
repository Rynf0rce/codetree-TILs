import java.util.*;
import java.io.*;
public class Main {
    public static final int MAX_INT = 1000000;
    public static final int MIN_INT = -1000000;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int maxVal = MIN_INT;
        int minVal = MAX_INT;
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0 ; i < n ; i++){
            int num = Integer.parseInt(st.nextToken());
            maxVal = Math.max(maxVal, num);
            minVal = Math.min(minVal, num);
        }
        System.out.print(minVal + " " + maxVal);
    }
}