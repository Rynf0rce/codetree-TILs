import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt(), b = sc.nextInt();
        int sum = a + b, cnt = 0;
        String str = Integer.toString(sum);
        for(int i = 0 ; i < str.length() ; i++){
            if(str.charAt(i) == '1'){
                cnt++;
            }
        }
        System.out.print(cnt);
    }
}