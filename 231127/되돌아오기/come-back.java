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
    public static final int NUM_OF_INPUT = 100;
    public static final int MAX_DISTANCE = 10;

    public static coordiante conFnc(coordiante current, char direction, int distance){
        int[] arrX = new int[]{0,1,0,-1}; // 북동남서    
        int[] arrY = new int[]{1,0,-1,0};
        coordiante output = new coordiante(current.x, current.y);
        int idx = 0;
        switch(direction){
            case 'N' :
                idx = 0;
                break;
            case 'E' :
                idx = 1;
                break;
            case 'S' :
                idx = 2;
                break;
            case 'W' :
                idx = 3;
                break;
            default :
                break;
        }
        output.x += arrX[idx] * distance;
        output.y += arrY[idx] * distance;

        return output;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] arr2D = new int[NUM_OF_INPUT*MAX_DISTANCE*2 + 1][NUM_OF_INPUT*MAX_DISTANCE*2 + 1];
        coordiante current = new coordiante(0,0);
        int num = sc.nextInt();
        int time = 0;
        boolean triger = false;
        for(int i = 0 ; i < num ; i++){
            char direction = sc.next().charAt(0);
            int distance = sc.nextInt();
            for(int j = 0 ; j < distance ; j++){
                current = conFnc(current, direction, 1);
                time++;
                if(current.x == 0 && current.y == 0){
                    triger = true;
                    break;
                }
            }
            if(triger){
                break;
            }
        }
        System.out.print(triger ? time : -1);       
    }
}