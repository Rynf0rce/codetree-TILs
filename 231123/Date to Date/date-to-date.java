// 2011년 m1월 d1일로부터 2011년 m2월 d2일까지는 총 며칠이 있는지를 계산하는 프로그램을 작성해보세요.
// 2011년은 윤년이 아닌 해이기 때문에 2월은 28일까지 있습니다. 단, 날짜 계산시 시작일을 포함하여 세도록 합니다.
import java.util.*;
public class Main {
    public static int conFnc(int month, int day){
        int[] monthToDay = new int[]{0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int sum = day;
        for(int i = 1 ; i < month ; i++){
            sum += monthToDay[i];
        }
        return sum ;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int sum = 0;
        for(int i = 0 ; i < 2 ; i++){
            int month = sc.nextInt();
            int day = sc.nextInt();
            if(i == 0){
                sum += conFnc(month, day);
            }
            else{
                sum -= conFnc(month, day);
            }
        }
        sum = Math.abs(sum) + 1;
        System.out.print(sum);
    }
}