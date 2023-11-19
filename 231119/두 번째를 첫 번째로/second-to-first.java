import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        char[] arr = str.toCharArray();
        char standard = arr[1];
        for(int i = 1 ; i < arr.length ; i++){
            if(arr[i] == standard){
                arr[i] = arr[0];
            }
        }
        for(int i = 0 ; i < arr.length ; i++){
            System.out.print(arr[i]);
        }
    }
}