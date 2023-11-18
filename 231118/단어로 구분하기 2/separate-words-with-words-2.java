import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] arr = new String[10];
        for(int i = 0 ; i < arr.length ; i++){
            arr[i] = sc.next();
            if((i+1)%2 == 1){
                System.out.println(arr[i]);
            }
            
        }
    }
}