import java.util.*;

public class Main {
    public static double[] arr = new double[3];

    public static int round(double a){
        if((a * 10) % 10  >= 5){
            return (int)a + 1;
        }
        return (int)a;
    }

    public static void printAns(){
        int ans = 0;
        for(int i = 0 ; i < 3 ; i++){
            ans += round(arr[i]);
        }

        System.out.printf("%d\n%d", ans, round((double)ans / 3));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for(int i = 0 ; i < 3 ; i++){
            arr[i] = sc.nextDouble();
        }
        printAns();
    }
}