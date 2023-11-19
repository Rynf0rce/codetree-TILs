import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        char[] arr = str.toCharArray();
        boolean triger = true;
        for(int i = 0 ; i < arr.length ; i++){
            if(arr[i] == 'e' && triger){
                triger = false;
            }
            else{
                System.out.print(arr[i]);
            }
        }
    }
}