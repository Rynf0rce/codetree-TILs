import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int maxVal = -1000;
        int minVal = 1000;
        while(st.hasMoreTokens()){
            int num = Integer.parseInt(st.nextToken());

            if(num == -999){
                break;
            }
            
            maxVal = Math.max(maxVal, num);
            minVal = Math.min(minVal, num);
        }
        System.out.print(maxVal + " " + minVal);
    }
}