import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int row = sc.nextInt(), column = sc.nextInt();
        for(int i = 1 ; i <= row ; i++){
            for(int j = 1 ; j <= column ; j++){
                System.out.print(i*j + " ");
            }
            System.out.println();
        }
    }
}