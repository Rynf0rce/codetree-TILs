import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int sum = 0;
        String str = "";
        for(int i = 0 ; i < num ; i++){
            sum += sc.nextInt();
        }

        str = Integer.toString(sum);
        System.out.print(str.substring(1) + str.substring(0,1));
    }
}