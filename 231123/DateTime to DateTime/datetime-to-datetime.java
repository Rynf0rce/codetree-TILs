// 2011년 11월 11일 11시 11분에서 시작하여 2011년 11월 a일 b시 c분까지 몇 분이 걸리는지를 계산하는 프로그램을 작성해보세요.
import java.util.*;
public class Main {
    public static int conFnc(int month, int day, int hour, int min){
        int[] monthToDay = new int[]{0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int sum = day;
        for(int i = 1 ; i < month ; i++){
            sum += monthToDay[i];
        }
        return ( sum * 24 + hour ) * 60 + min;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int sum = conFnc(11,11,11,11);
        int a = sc.nextInt(), b = sc.nextInt(), c = sc.nextInt();
        sum -= conFnc(11,a,b,c);
        sum = Math.abs(sum);
        System.out.print(sum);
    }
}