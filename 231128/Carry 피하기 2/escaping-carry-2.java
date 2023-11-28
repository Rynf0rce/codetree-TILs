import java.util.*;

public class Main {
    public static int notCarryButMaximum(int a, int b, int c){
        int temp_A = a, temp_B = b, temp_C = c;
        int remainder_A = 0, remainder_B = 0, remainder_C = 0;
        while(true){
            if(temp_A != 0 && temp_B != 0 && temp_C != 0){
                if(temp_A % 10 + temp_B % 10 + temp_C % 10  >= 10){
                    return -1;
                }
                else{
                    temp_A /= 10;
                    temp_B /= 10;
                    temp_C /= 10;
                }
            }
            else{
                return a + b + c;
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0 ; i < arr.length ; i++){
            arr[i] = sc.nextInt();
        }

        int maxVal = Integer.MIN_VALUE;
        for(int i = 0 ; i < arr.length - 2; i++){
            for(int j = i + 1 ; j < arr.length - 1 ; j++){
                for(int h = j + 1 ; h < arr.length ; h++){
                    maxVal = Math.max(maxVal, notCarryButMaximum(arr[i], arr[j], arr[h]));
                }
            }
        }
        System.out.print(maxVal);
    }
}