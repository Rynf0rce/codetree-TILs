import java.util.*;
import java.io.*;

public class Main {
    public static final int MAX_INT = 200;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int mindist = MAX_INT;
        int closeVal = MAX_INT;
        int minVal = MAX_INT + 1;
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0 ; i < n ; i++){
            int num = Integer.parseInt(st.nextToken());
            if(mindist > Math.abs(100 - num)){
                closeVal = num;
                mindist = Math.abs(100 - num);
            }
            else if(mindist == Math.abs(100 - num)){
                closeVal = Math.min(closeVal, num);
            }

            if(num >= 100){
                minVal = Math.min(minVal, num);
            }
        }
        System.out.print(closeVal + " " + (minVal == MAX_INT + 1 ? -1 : minVal));
    }
}