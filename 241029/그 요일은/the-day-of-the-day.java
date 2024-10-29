import java.util.*;
public class Main {
    public static String[] dayArr = new String[]{"Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"};
    public static int[] arr = new int[]{0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m1 = sc.nextInt();
        int d1 = sc.nextInt();
        int m2 = sc.nextInt();
        int d2 = sc.nextInt();
        String str = sc.next();

        int left = d1;
        for(int i = 0 ; i < m1 ; i++){
            left += arr[i];
        }

        int right = d2;
        for(int i = 0 ; i < m2 ; i++){
            right += arr[i];
        }

        int val = right - left;
        int ans = val / 7;
        for(int i = 1 ; i <= val % 7 ; i++){
            if(dayArr[i].equals(str)){
                ans++;
            }
        }
        System.out.print(ans);

    }
}