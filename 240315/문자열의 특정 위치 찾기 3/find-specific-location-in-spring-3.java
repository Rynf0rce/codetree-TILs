import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] arr = String.valueOf(sc.next()).toCharArray();
        char target = sc.next().charAt(0);
        for(int i = 0 ; i < arr.length ; i++){
            if(arr[i] == target){
                System.out.print(i + 1);
                System.exit(0);
            }
        }
        System.out.print("Not Found");
    }
}