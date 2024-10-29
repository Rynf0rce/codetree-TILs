import java.util.*;

public class Main {
    public static boolean Palindrome(int num){
        int[] arr = new int[10];
        String str = String.valueOf(num);

        int j = str.length() - 1;
        for(int i = 0 ; i < str.length() ; i++){
            if(j <= i){
                break;
            }
            
            int left = Integer.parseInt(str.charAt(i) + "");
            int right = Integer.parseInt(str.charAt(j) + "");

            if(left != right){
                return false;
            }

            j--;
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int X = sc.nextInt();
        int Y = sc.nextInt();

        int ans = 0;
        for(int i = X ; i <= Y ; i++){
            if(Palindrome(i)) ans++;
        }
        System.out.print(ans);
    }
}