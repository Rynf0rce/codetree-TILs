import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        char[] arr = input.toCharArray();
        for(int i = 0 ; i < arr.length ; i++){
            if(arr[i] == arr[0]){
                System.out.print(arr[1]);
            }
            else if(arr[i] == arr[1]){
                System.out.print(arr[0]);
            }
            else{
                System.out.print(arr[i]);
            }
        }
    }
}