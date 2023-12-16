import java.util.*;

public class Main {
    public static int RLE(char[] arr){
        String str = "";
        char curChar = '0';
        int cnt = 0;
        for(int i = 0 ; i < arr.length ; i++){
            if(i == 0){
                curChar = arr[i];
                cnt = 1;
            }
            else if(curChar == arr[i]){
                cnt++;
                if(i == arr.length - 1){
                    str += curChar + Integer.toString(cnt);
                }
            }
            else{
                str += curChar + Integer.toString(cnt);
                curChar = arr[i];
                cnt = 1;
                if(i == arr.length - 1){
                    str += curChar + Integer.toString(cnt);
                }
            }
        }
        return str.length();
    }

    public static void shift(char[] arr){
        char temp = arr[arr.length - 1];
        for(int i = arr.length - 1 ; i > 0 ; i--){
            arr[i] = arr[i-1];
        }
        arr[0] = temp;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] arr = sc.next().toCharArray();
        int minVal = Integer.MAX_VALUE;
        for(int i = 0 ; i < arr.length ; i++){
            minVal = Math.min(minVal, RLE(arr));
            shift(arr);
        }
        System.out.println(minVal);
    }
}