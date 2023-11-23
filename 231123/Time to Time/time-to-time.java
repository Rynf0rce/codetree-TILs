//2011년 11월 11일 a시 b분에서 시작하여 2011년 11월 11일 c시 d분까지 몇 분이 걸리는지를 계산하는 프로그램을 작성해보세요.
import java.util.*;

public class Main {
    public static int miunte(int hour, int min){
        return hour * 60 + min;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt(), b = sc.nextInt(), c = sc.nextInt(), d = sc.nextInt();
        int time1 = miunte(a,b), time2 = miunte(c,d);
        System.out.print(Math.abs(time1-time2));
    }
}