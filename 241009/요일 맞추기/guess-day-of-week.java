import java.util.*;
public class Main {
    public static int conFnc(int month, int day){
        int[] monthToDay = new int[]{0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int sum = day;
        for(int i = 1 ; i < month ; i++){
            sum += monthToDay[i];
        }
        return sum;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] week = new String[]{"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"};
        int idx = 1, m1 = sc.nextInt(), d1 = sc.nextInt(), m2 = sc.nextInt(), d2 = sc.nextInt();
        /*m1 = 12;
        d1 = 25;
        m2 = 7;
        d2 = 19;*/
        int totalDay1 = conFnc(m1,d1), totalDay2 = conFnc(m2,d2);
        int gap = Math.abs(totalDay1 - totalDay2) % 7;
        if(totalDay1 > totalDay2){
            if(gap == 1){
                System.out.print(week[0]);
            }
            else{
                System.out.print(week[6-(gap-2)]);
            }
            
        }
        else{
            System.out.print(week[(gap+1)%7]);
        }
        
    }
}