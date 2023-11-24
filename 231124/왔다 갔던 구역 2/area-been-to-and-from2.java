// 위치 0에서 시작하여 n번의 명령에 걸쳐 움직인 뒤, 2번 이상 지나간 영역의 크기를 출력하는 프로그램을 작성해보세요.
// 단 명령은 “x L“, “x R” 형태로만 주어집니다. "x L" 의 경우 왼쪽으로 x만큼 이동해야 함을, "x R"의 경우 오른쪽으로 x만큼 이동해야 함을 뜻합니다.
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt(), current = 1000, cnt = 0;
        int[] arr = new int[2001];

        // num = 2;
        //int[] testarr = new int[]{1,1};
        //char[] testdir = new char[]{'R','L'};
        for(int i = 0 ; i < num ; i++){
            int step = sc.nextInt();// testarr[i];//
            char direct = sc.next().charAt(0); // testdir[i];//
            switch(direct){
                case 'R' :
                    for(int j = current ; j < current + step ; j++){
                        arr[j]++;
                    }
                    current += step;
                    break;
                case 'L' :
                    for(int j = current - 1; j >= current - step ; j--){
                        arr[j]++;
                    }
                    current -= step;
                    break;
                default :
                    break;
            }
            // System.out.println("current : " + current);
        }
        for(int i = 1 ; i < arr.length ; i++){
            if(arr[i] > 1){
                cnt++;
                //System.out.println(i);
            }
        }
        System.out.print(cnt);
    }
}