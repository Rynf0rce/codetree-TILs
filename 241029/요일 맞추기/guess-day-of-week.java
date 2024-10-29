import java.util.*;
public class Main {
    public static String[] dayArr = new String[]{"Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"};
    public static int[] arr = new int[]{0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m1 = sc.nextInt();
        int d1 = sc.nextInt();
        int m2 = sc.nextInt();
        int d2 = sc.nextInt();

        int left = d1;
        for(int i = 0 ; i < m1 ; i++){
            left += arr[i];
        }

        int right = d2;
        for(int i = 0 ; i < m2 ; i++){
            right += arr[i];
        }

        int val = right - left;
        val = val % 7;
        if(val >= 0){
            System.out.print(dayArr[val]);
        }
        else{
            System.out.print(dayArr[7 + val]);
        }
    }
}