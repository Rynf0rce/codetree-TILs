import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();
        int currentVal = input, power = 0;
        while(true){
            if(currentVal / 2 > 0 && currentVal % 2 == 0){
                power++;
                currentVal /= 2;
            }
            else{
                break;
            }
        }
        System.out.print(power);
    }
}