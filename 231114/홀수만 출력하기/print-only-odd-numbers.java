import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        int input = 0;
        for(int i = 0 ; i < number ; i++){
            input = sc.nextInt();
            if(input % 2 == 1 && input % 3 == 0){
                System.out.println(input);
            }
        }
    }
}