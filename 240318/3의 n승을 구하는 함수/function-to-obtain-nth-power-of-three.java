import java.util.*;

public class Main {
    public static int pow(int num, int cnt){
        if(cnt == 1){
            return num;
        }
        return num * pow(num, cnt - 1);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.print(pow(3, n));
    }
}