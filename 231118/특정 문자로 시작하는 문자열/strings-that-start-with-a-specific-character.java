import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] arr = new String[n];
        int sum = 0, cnt = 0;
        char criteria = ' ';
        
        for(int i = 0; i < arr.length ; i++){
            arr[i] = sc.next();
        }

        criteria = sc.next().charAt(0);

        for(int i = 0; i < arr.length ; i++){
            if(arr[i].charAt(0) == criteria){
                sum += arr[i].length();
                cnt++;
            }
        }
        System.out.printf("%d %.2f", cnt, (double)sum / cnt);
    }
}