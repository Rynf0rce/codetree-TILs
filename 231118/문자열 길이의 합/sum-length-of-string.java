import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] arr = new String[n];
        int sum = 0, cnt = 0;
        for(int i = 0; i < arr.length ; i++){
            arr[i] = sc.next();
            sum += arr[i].length();
            for(int j = 0 ; j < arr[i].length() ; j++){
                if(arr[i].charAt(j) == 'a'){
                    cnt++;
                    break;
                }
            }
        }
        System.out.println(sum + " " + cnt);
    }
}