import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), cnt = 0;
        String[] arr = new String[n];
        for(int i = 0 ; i < arr.length ; i++){
            arr[i] = sc.next();
            for(int j = 0 ; j < arr[i].length() ; j++){
                System.out.print(arr[i].charAt(j));
                cnt++;
                if(cnt > 4){
                    System.out.println();
                    cnt = 0;
                }
            }
        }
    }
}