import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt(), B = sc.nextInt(), C = sc.nextInt(), maxVal = Integer.MIN_VALUE;
        for(int i = 0 ; i <= C / A ; i++){
            for(int j = 0 ; j <= C / B ; j++){
                int currentVal = A * i + B * j;
                if(currentVal <= C){
                    maxVal = Math.max(maxVal, currentVal);
                }
            }
        }
        System.out.print(maxVal);
    }
}