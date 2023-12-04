// 이전에는 각 선에 위치되어 있는 값을 배열에 기록해서 중복 여부 파악
// 이번에는 기하학적으로 접근해서 문제 풀이하는 방법.
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x1 = sc.nextInt(), x2 = sc.nextInt(), x3 = sc.nextInt(), x4 = sc.nextInt();
        if(x4 > x1 || x3 < x2){
            System.out.println("intersecting");
        }
        else{
            System.out.println("nonintersecting");
        }
    }
}