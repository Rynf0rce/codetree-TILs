import java.util.*;

public class Main {
    public static int findMax(int a, int b){
        if(a > b){
            return a;
        }
        return b;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int maxVal = -100;
        for(int i = 0 ; i < 3 ; i++){
            int num = sc.nextInt();
            maxVal = findMax(maxVal, num);
        }
        System.out.print(maxVal);
    }
}