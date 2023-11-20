import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        char[] arr = str.toCharArray();
        for(int i = 0 ; i < arr.length ; i++){
            if(arr[i] >= 'a' && arr[i] <= 'z'){
                System.out.print((char)(arr[i] - 'a' + 'A'));
            }
            else if(arr[i] >= 'A' && arr[i] <= 'Z'){
                System.out.print(arr[i]);
            }
        }
    }
}