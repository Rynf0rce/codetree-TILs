import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int input = 0, sumVal = 0, cnt = 0;
        while(true){
            input = sc.nextInt();
            if(input / 10 == 2){
                 sumVal += input;
                 cnt++;
            }
            else{
                System.out.printf("%.2f", (double)sumVal/cnt);
                break;
            }
        }
    }
}