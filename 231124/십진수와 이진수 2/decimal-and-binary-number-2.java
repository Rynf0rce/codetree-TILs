import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input= sc.next();
        int sum = 0, idx = 0;;
        int[] arr = new int[100];
        for(int i = 0; i < input.length() ; i++){
            sum = sum * 2 + ( input.charAt(i) - '0');
        }
        
        sum *= 17;

        while(true){
            if(sum / 2 == 0){
                arr[idx] = sum % 2;
                break;
            }
            else{
                arr[idx] = sum % 2;
                sum /= 2;
            }
            idx++;
        }

        for(int i = idx ; i >= 0 ; i--){
            System.out.print(arr[i]);
        }
    }
}