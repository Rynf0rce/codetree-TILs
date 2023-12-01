import java.util.*;

public class Main {
    public static boolean palindrome(int input){
        char[] arr = String.valueOf(input).toCharArray();
        for(int i = 0 ; i < arr.length /2 ; i++ ){
            if(arr[i] != arr[arr.length -1 - i]){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int X = sc.nextInt(), Y = sc.nextInt(), cnt = 0;;
        for(int i = X ; i <= Y ; i++){
            if(palindrome(i)){
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}