import java.util.*;

public class Main {
    public static int binaryToDeciaml(String binary){
        int sum = 0;
        char[] arr = binary.toCharArray();
        for(int i = 0 ; i < arr.length ; i++){
            if(arr[i] == '1'){
                sum++;
            }
            if(i != arr.length - 1){
                sum *= 2;
            }
        }
        return sum;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        System.out.print(binaryToDeciaml(input));
    }
}