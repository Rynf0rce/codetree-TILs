import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] arr = new String[10];
        boolean triger = false;
        for(int i = 0 ; i < arr.length ; i++){
            arr[i] = sc.next();
        }

        char criteria = sc.next().charAt(0);

        for(int i = 0 ; i < arr.length ; i++){
            if(arr[i].charAt(arr[i].length() - 1) == criteria){
                System.out.println(arr[i]);
                triger = true;
            }
        }
        if(!triger){
            System.out.print("None");
        }
    }
}