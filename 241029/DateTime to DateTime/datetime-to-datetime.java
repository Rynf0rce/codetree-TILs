import java.util.*;
public class Main {
    public static final int HOUR_TO_MINTE = 60;
    public static final int DAY_TO_HOUR = 24;
    public static final int DAY = 11;
    public static final int HOUR = 11;
    public static final int MINTE = 11;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        
        int ans = ( a * DAY_TO_HOUR * HOUR_TO_MINTE + b * HOUR_TO_MINTE + c) - ( DAY * DAY_TO_HOUR * HOUR_TO_MINTE + HOUR * HOUR_TO_MINTE + MINTE );
        System.out.print(ans < 0 ? -1 : ans);
    }
}