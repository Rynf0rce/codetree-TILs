// 2차 평면 위에 N개의 점이 주어졌을 때, 원점에서 가까운 점부터 순서대로 번호를 출력하는 프로그램을 작성해보세요. 거리가 같은 점이 여러 개인 경우, 번호가 작은 점 부터 출력합니다.
// 단, 여기서의 거리란 멘하턴 거리를 의미합니다. 두 점 (x1, y1), (x2, y2) 사이의 멘하턴 거리는 |x1 - x2| + |y1 - y2|로 정의됩니다.
import java.util.*;

class coordinate implements Comparable<coordinate>{
    int idx;
    int x;
    int y;

    public coordinate(){}

    public coordinate(int idx, int x, int y){
        this.idx = idx;
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(coordinate input){
        return (Math.abs(this.x) + Math.abs(this.y)) - (Math.abs(input.x) + Math.abs(input.y));
    }
}


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        coordinate[] arr = new coordinate[num];
        for(int i = 0 ; i < arr.length ; i++){
            int idx = i+1;
            int x = sc.nextInt();
            int y = sc.nextInt();
            arr[i] = new coordinate(idx, x,y);
        }

        Arrays.sort(arr);

        for(int i = 0 ; i < arr.length ; i++){
            System.out.println(arr[i].idx);
        }  
    }
}