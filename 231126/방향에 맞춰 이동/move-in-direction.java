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

    public static cooridnate move(cooridnate input, char direction, int distance){
        cooridnate temp = new cooridnate(input.x, input.y);
        int[] arrX = new int[]{1, -1, 0, 0}; // 동서남북
        int[] arrY = new int[]{0, 0, -1, 1};
        int idx = 0;
        switch(direction){
            case 'E':
                idx = 0;
                break;
            case 'W' : 
                idx = 1;
                break;
            case 'S' :
                idx = 2;
                break;
            case 'N' :
                idx = 3;
                break;
        }
        temp.x += arrX[idx] * distance;
        temp.y += arrY[idx] * distance;

        return temp;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        cooridnate current = new cooridnate(0,0);
        for(int i = 0 ; i < num ; i++){
            char direction = sc.next().charAt(0);
            int distance = sc.nextInt();
            current = (cooridnate) move(current, direction, distance);
        }
        System.out.print(current.x + " " + current.y);
    }
}