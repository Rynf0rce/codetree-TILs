import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for(int i = 0 ; i < 5 ; i++){
            int sum = 0;
            for(int j = 0 ; j < 4 ; j++){
                sum += sc.nextInt();
            }
            System.out.println(sum);
        }
    }
}