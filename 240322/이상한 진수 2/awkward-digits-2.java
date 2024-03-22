import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] arr = sc.next().toCharArray();
        int sum = 0;
        boolean triger = true;
        for(int i = 0 ; i < arr.length ; i++){
            if(arr[i] == '1'){
                sum += Math.pow(2, arr.length - 1 - i);
            }
            else if(arr[i] == '0' && triger){
                sum += Math.pow(2, arr.length - 1 - i);
                triger = false;
            }
        }

        if(triger){
            System.out.print(sum - 1);
        }
        else{
            System.out.print(sum);
        }
    }
}