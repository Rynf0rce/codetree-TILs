import java.util.*;

public class Main {
    public static final int MAX_LENGTH = 100;
    public static int[] right = new int[100 + 2];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] arr = sc.next().toCharArray();

        if(arr[arr.length - 1] ==  ')'){
            right[arr.length - 1] = 1;
        }

        for(int i = arr.length - 2 ; i >= 0 ; i--){
            if(arr[i] == ')'){
                right[i] = right[i + 1] + 1;
            }
            else{
                right[i] = right[i + 1];
            }
        }

        int ans = 0;
        for(int i = 0 ; i < arr.length ; i++){
            if(arr[i] == '('){
                ans += right[i];
            }
        }
        System.out.print(ans);
    }
}