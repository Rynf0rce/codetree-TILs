import java.util.*;
public class Main {
    public static String[] arr = new String[4];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < 4 ; i++){
            sb.append(sc.next());
            arr[i] = sb.reverse().toString();
            sb.setLength(0);
        }

        for(int i = 3 ; i >= 0 ; i--){
            System.out.println(arr[i]);
        }
    }
}