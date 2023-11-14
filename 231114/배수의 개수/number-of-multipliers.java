import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int input = 0, counterThree = 0, counterFive = 0;
        for(int i = 0 ; i < 10 ; i++){
            input = sc.nextInt();
            if(input % 3 == 0){
                counterThree++;
            }
            if(input % 5 == 0){
                counterFive++;
            }
        }
        System.out.printf("%d %d", counterThree, counterFive);
    }
}