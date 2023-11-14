import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int middleS = sc.nextInt();
        int finalS = sc.nextInt();
        int output = 0;

        if(middleS >= 90){
            if(finalS >= 95){
                output = 100000;
            }
            else if(finalS >= 90){
                output = 50000;
            }
            else{
                output = 0;
            }
        }
        else{
            output = 0;
        }
        System.out.print(output);
    }
}