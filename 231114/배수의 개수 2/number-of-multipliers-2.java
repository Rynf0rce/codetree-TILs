import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int input = 0, counter = 0;
        for(int i = 0 ; i < 10 ; i++){
            input = sc.nextInt();
            if(input % 2 == 1){
                counter++;
            }
        }
        System.out.print(counter);
    }
}