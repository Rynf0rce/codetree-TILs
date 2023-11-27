import java.util.*;

public class Main {
    public static int binaryToDecimal(char[] arr){
        int sum = 0;
        for(int i = arr.length -1 ; i >= 0 ; i--){
            if(arr[i] == '1'){
                sum += Math.pow(2, Math.abs(arr.length - 1 - i));
            }
        }
        return sum;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        char[] arr = input.toCharArray();
        int maxVal = Integer.MIN_VALUE;
        for(int i = arr.length -1 ; i >= 0 ; i--){
            char[] tempArr = arr.clone();
            if(tempArr[i] == '0'){
                tempArr[i] = '1';
                maxVal = Math.max(maxVal, binaryToDecimal(tempArr));
            }
            else{
                tempArr[i] = '0';
                maxVal = Math.max(maxVal, binaryToDecimal(tempArr));
            }
        }
        System.out.print(maxVal);
    }
}