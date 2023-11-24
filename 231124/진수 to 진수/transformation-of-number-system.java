import java.util.*;

public class Main {
    public static void systemChange(int a, int b, int n){
        int value = 0;
        char[] arr = Integer.toString(a).toCharArray();
        for(int i = 0; i < arr.length ; i++){
            value = value * a + ( arr[i] - '0' );
        }

        int[] outputArr = new int[100];
        int idx = 0;
        while(true){
            outputArr[idx] = value % b;
            if(value / b == 0){
                break;
            }
            else{
                value /= b;
            }
            idx++;
        }

        for(int i = idx ; i >= 0 ; i--){
            System.out.print(outputArr[i]);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt(), b = sc.nextInt(), n = nextInt();
        systemChange(a,b,n);
    }
}