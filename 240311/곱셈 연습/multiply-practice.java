import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        char[] mArr = ("" + m).toCharArray();
        for(int i = mArr.length - 1 ; i >= 0 ; i--){
            System.out.println(n * (mArr[i] - '0'));
        }
        System.out.print(n * m);
    }
}