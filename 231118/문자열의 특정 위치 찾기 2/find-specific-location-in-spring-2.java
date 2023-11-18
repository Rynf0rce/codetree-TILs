import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] arr = new String[]{"apple", "banana", "grape", "blueberry", "orange"};
        char input = sc.next().charAt(0);
        int cnt = 0 ;
        for(int i = 0 ; i < arr.length ; i++){
            if(arr[i].charAt(2) == input || arr[i].charAt(3) == input){
                System.out.println(arr[i]);
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}