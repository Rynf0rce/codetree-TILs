import java.util.*;
public class Main {
    public static final int MAX_LENGTH = 30;
    public static boolean[] arr = new boolean[MAX_LENGTH + 1];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for(int i = 0 ; i < 28 ; i++){
            int idx = sc.nextInt();
            arr[idx] = true;
        }

        for(int i = 1 ; i <= 30 ; i++){
            if(!arr[i]){
                System.out.println(i);
            }
        }
    }
}