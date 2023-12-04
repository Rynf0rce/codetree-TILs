// 기하하적으로 문제 풀이
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt(), b = sc.nextInt(), c = sc.nextInt(), d = sc.nextInt();
        int sum = b - a + d - c;
        if(c >= a && d <= b ){
            sum -= (d - c);
        }
        else if(c <= a  && b <= d){
            sum -= (b - a);
        }
        else if(c > a && b > c){
            sum -= (b - c);
        }
        else if(a > c && d > a){
            sum -= (d - a);
        }
        System.out.println(sum);
    }
}