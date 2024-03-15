import java.util.*;
public class Main {
    public static final int MAX_INT = 1000000;
    public static final int MIN_INT = -1000000;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int maxVal = MIN_INT;
        int minVal = MAX_INT;
        int n = sc.nextInt();
        for(int i = 0 ; i < n ; i++){
            int num = sc.nextInt();
            maxVal = Math.max(maxVal, num);
            minVal = Math.min(minVal, num);
        }
        System.out.print(minVal + " " + maxVal);
    }
}