import java.util.*;

public class Main {
    public static boolean conFuc(int i){
        int cnt = 0;
        for(int a = 1 ; a <= i ; a++){
            if(i % a == 0){
                cnt++;
            }
            if(cnt > 2){
                return false;
            }
        }

        char[] arr = String.valueOf(i).toCharArray();
        int sum = 0;
        for(int a = 0 ; a < arr.length ; a ++){
            sum += (arr[a] - '0');
        }

        if(sum % 2 == 0){
            return true;
        }
        else{
            return false;
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt(), b = sc.nextInt(), cnt = 0;
        for(int i = a ; i <= b ; i++){
            if(conFuc(i)){
                cnt++;
            }
        }
        System.out.print(cnt);
    }
}