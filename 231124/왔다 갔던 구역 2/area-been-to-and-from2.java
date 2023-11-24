// 1차원 직선 상에 n개의 선분이 놓여 있습니다. 가장 많이 겹치는 곳에서는,
// 몇 개의 선분이 겹치는지를 구하는 프로그램을 작성해보세요. 단, 끝점에서 닿는 경우에도 겹치는 것으로 봅니다.
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt(), current = 1000, cnt = 0;
        int[] arr = new int[2001];
        for(int i = 0 ; i < num ; i++){
            int step = sc.nextInt();
            char direct = sc.next().charAt(0);
            switch(direct){
                case 'R' :
                    for(int j = current ; j < current + step ; j++){
                        arr[j]++;
                    }
                    current += step;
                    break;
                case 'L' :
                    for(int j = current ; j > current - step ; j--){
                        arr[j]++;
                    }
                    current -= step;
                    break;
                default :
                    break;
            }
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