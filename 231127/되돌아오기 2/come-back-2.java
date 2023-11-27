import java.util.*;

class coordiante{
    int x;
    int y;

    coordiante(){}
    coordiante(int x, int y){
        this.x = x;
        this.y = y;
    }
}

public class Main {
    public static final int NUM_OF_INPUT = 100000;
    public static int direction = 0;

    public static coordiante conFnc(coordiante current, char order, int distance){
        int[] arrX = new int[]{0,1,0,-1}; // 북동남서    
        int[] arrY = new int[]{1,0,-1,0};
        coordiante output = new coordiante(current.x, current.y);
        switch(order){
            case 'L' :
                direction--;
                if(direction < 0){
                    direction = 3;
                }
                break;
            case 'R' :
                direction = (direction + 1) % 4;
                break;
            case 'F':
                output.x += arrX[direction] * distance;
                output.y += arrY[direction] * distance;
                break;
        }
        return output;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        coordiante current = new coordiante(0,0);
        String input = sc.next();
        char[] inputArr = input.toCharArray();
        int time = 0;
        boolean triger = false;
        for(int i = 0 ; i < inputArr.length ; i++){
            current = conFnc(current, inputArr[i], 1);
            time++;
            if(current.x == 0 && current.y == 0){
                triger = true;
                break;
            }
        }
        System.out.print(triger ? time : -1);       
    }
}