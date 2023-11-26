import java.util.*;

class cooridnate{
    int x;
    int y;
    cooridnate(){}

    cooridnate(int x, int y){
        this.x = x;
        this.y = y;
    }
}

public class Main {
    public static final int NUM_OF_ORDER = 100;

    public static cooridnate move(cooridnate input, int direction, int distance){
        cooridnate temp = new cooridnate(input.x, input.y);
        int[] arrX = new int[]{0, 1, 0, -1}; // 북동남서
        int[] arrY = new int[]{1, 0, -1, 0};
        temp.x += arrX[direction] * distance;
        temp.y += arrY[direction] * distance;

        return temp;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        char[] orderArr = input.toCharArray();
        cooridnate current = new cooridnate(0,0);
        int direction = 0;
        for(int i = 0 ; i < orderArr.length ; i++){
            if(orderArr[i]== 'L'){
                direction--;
                if(direction < 0){
                    direction = 3;
                }
            }
            else if(orderArr[i] == 'R'){
                direction++;
            }
            else{
                current = (cooridnate) move(current, direction % 4, 1);
            }
        }
    
        System.out.print(current.x + " " + current.y);
    }
}