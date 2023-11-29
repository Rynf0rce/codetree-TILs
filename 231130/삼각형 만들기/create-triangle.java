import java.util.*;

class coordinate implements Comparable<coordinate>{
    int x;
    int y;
    int idx;

    coordinate(){}

    coordinate(int x, int y, int idx){
        this.x = x;
        this.y = y;
        this.idx = idx;
    }

    @Override
    public int compareTo(coordinate input){
        return this.x - input.x;
    }
}

public class Main {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        coordinate[] arr = new coordinate[num];
        for(int i = 0 ; i < arr.length ; i++){
            int x = sc.nextInt();
            int y = sc.nextInt();
            arr[i] = new coordinate(x,y,i);
        }

        // Arrays.sort(arr);
        
        int area = 0;
        for(int i = 0 ; i < arr.length ; i++){
            for(int j = 0 ; j < arr.length ; j++ ){
                for(int k = 0 ; k < arr.length ; k++){
                    if(i == j || j == k || i == k){
                        continue;
                    }
                    else if(arr[i].y == arr[j].y && ( arr[i].x == arr[k].x || arr[j].x == arr[k].x )){
                        area = Math.abs ( (arr[i].x - arr[j].x ) * ( arr[i].y - arr[k].y ) );
                    }
                }
            }
        }
        System.out.println(area);
    }
}