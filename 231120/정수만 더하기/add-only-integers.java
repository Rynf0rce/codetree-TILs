import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        char[] arr = str.toCharArray();
        int sum = 0;
        for(int i = 0 ; i < arr.length ; i++){
            if(arr[i] >= '0' && arr[i] <= '9'){
                sum = sum + (int)(arr[i] - '0');
            }
        }
        System.out.print(sum);
    }
}