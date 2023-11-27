import java.util.*;

class coordinate{
    int x;
    int y;

    coordinate(){}
    coordinate(int x, int y){
        this.x = x;
        this.y = y;
    }
}

public class Main {
    public static int skipDistance(coordinate[] arr, int skip){
        int startX = arr[0].x, startY = arr[0].y, output = 0;
        for(int i = 1 ; i < arr.length ; i++){
            if(i == skip){
                continue;
            }
            else{
                int tempX = arr[i].x;
                int tempY = arr[i].y;
                output += ( Math.abs(startX - tempX) + Math.abs(startY - tempY) );
                startX = tempX;
                startY = tempY;
            }
        }
        return output;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        coordinate[] arr = new coordinate[num];
        for(int i = 0 ; i < num ; i++){
            int x = sc.nextInt();
            int y = sc.nextInt();
            arr[i] = new coordinate(x,y);
        }

        int minVal = Integer.MAX_VALUE;

        for(int i = 1 ; i < num -1 ; i++){
            int value = skipDistance(arr, i);
            if(minVal > value){
                minVal = value;
            }
        }
        System.out.print(minVal);
    }
}