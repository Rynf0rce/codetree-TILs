import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int input = 0;
        while(true){
            input = sc.nextInt();
            if(input == 0){
                break;
            }
            System.out.println(input);
        }
    }
}