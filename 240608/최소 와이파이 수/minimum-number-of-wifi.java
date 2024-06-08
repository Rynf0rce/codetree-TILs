import java.util.*;

public class Main {
    public static final int MAX_RANGE = 100;
    public static int[] arr = new int[MAX_RANGE];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt(), output = Integer.MAX_VALUE;
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
                    WiFi++;
                    j = i;
                }
                else if(triger){
                    WiFi++;
                    j += (2*m + 1);
                }
                else{
                    j++;
                }
                triger = false;
            }
            output = Math.min(output, WiFi);
        }
        System.out.println(output);
    }
}