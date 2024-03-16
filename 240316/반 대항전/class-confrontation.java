import java.util.*;
import java.io.*;
public class Main {
    public static final int MAX_CLASS = 4;
    public static int[] point = new int[MAX_CLASS];
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        int maxVal = 0;
        char c = ' ';
        for(int i = 0 ; i < 4 ; i++){
            String[] arr = br.readLine().split(" ");
            int sum = 0;
            for(int j = 1 ; j <= n ; j++){
                sum += Integer.valueOf(arr[j]);
            }

            point[arr[0].charAt(0) - 'A'] = sum;

            if(maxVal < sum){
                maxVal = sum;
                c = arr[0].charAt(0);
            }
        }

        for(int i = 0 ; i < 4 ; i++){
            System.out.println((char)(i + 'A') + " - " + point[i]);
        }
        System.out.printf("Class %c is winner!", c);
    }
}