// 2011년 m1월 d1일이 월요일 이었다면, 2011년 m2월 d2은 어떤 요일인지를 구하는 프로그램을 작성해보세요.
// 2011년은 윤년이 아닌 해이기 때문에 2월은 28일까지 있습니다.
import java.util.*;
public class Main {
    public static int conFnc(int month, int day){
        int[] monthToDay = new int[]{0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int sum = day;
        for(int i = 1 ; i < month ; i++){
            sum += monthToDay[i];
        }
        return sum;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] weekArr = new String[]{"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"};
        int Mon = 1, idx = 0, m1 = sc.nextInt(), d1 = sc.nextInt(), m2 = sc.nextInt(), d2 = sc.nextInt();
        String week = sc.next();
        int totalDay1 = conFnc(m1,d1), totalDay2 = conFnc(m2,d2);
        // System.out.println(Math.abs(totalDay1 - totalDay2));
        int gap = Math.abs(totalDay1 - totalDay2) % 7 , cnt = Math.abs(totalDay1 - totalDay2) / 7;
        for(int i = 0 ; i < weekArr.length ; i++){
            if(week.equals(weekArr[i])){
                idx = i;
                break;
            }
        }
        int sum = cnt;
        // System.out.println(gap);
        if(idx <= 1 + gap){
            sum++;
        }
        System.out.print(sum);
        
    }
}