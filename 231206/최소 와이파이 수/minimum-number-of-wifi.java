import java.util.*;

public class Main {
    public static final int MAX_RANGE = 100;
    public static int[] arr = new int[MAX_RANGE];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt(), minVal = 0, output = Integer.MAX_VALUE;
        for(int i = 0 ; i < n ; i++){
            arr[i] = sc.nextInt();
        }
        
        for(int i = 0 ; i < 2 * m + 1 ; i++){
            int WiFi = 0;
            int cnt = 0;
            boolean triger = false;
            for(int j = 0 ; j < n ; ){
                if(arr[j] == 1){
                    triger = true;
                }

                if(triger && i>j && j == i - 1){
                    //System.out.println("A");
                    WiFi++;
                    j = i;
                }
                else if(triger){
                    //System.out.println("B");
                    WiFi++;
                    j += (2*m + 1);
                }
                else{
                    //System.out.println("C");
                    j++;
                }
                triger = false;
                // System.out.print("current I : " + i + " current J : " + j +  " current WIFI : " + WiFi + "\n");
            }
            //System.out.println();
            output = Math.min(output, WiFi);
        }
        System.out.println(output);
    }
}