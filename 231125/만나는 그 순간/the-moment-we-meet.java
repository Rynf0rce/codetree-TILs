import java.util.*;

public class Main {
    public static final int NUM_OF_BEHAVIOR = 1000;
    public static final int MAXIMUM_SEOND = 1000;

    public static int run(char direction, int second){
        switch(direction){
            case 'R' :
                return second;
            case 'L' :
                return second * (-1);
            default :
                return 0;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] A_arr = new int[NUM_OF_BEHAVIOR * MAXIMUM_SEOND];
        int[] B_arr = new int[NUM_OF_BEHAVIOR * MAXIMUM_SEOND];
        int A_action = sc.nextInt(), A_idx = 1, B_action = sc.nextInt(), B_idx = 1;
        for(int i = 0 ; i < A_action ; i++){
            char direction = sc.next().charAt(0);
            int second = sc.nextInt();
            for(int j = 1 ; j <= second ; j++){
                A_arr[A_idx] = run(direction, 1) + A_arr[A_idx -1];
                A_idx++;
            }
        }

        for(int i = 0 ; i < B_action ; i++){
            char direction = sc.next().charAt(0);
            int second = sc.nextInt();
            for(int j = 1 ; j <= second ; j++){
                B_arr[B_idx] = run(direction, 1) + B_arr[B_idx -1];
                B_idx++;
            }
        }

        int count = Math.min(A_idx, B_idx);
        boolean chack = false;

        for(int i = 1 ; i < count ; i++){
            if(A_arr[i] == B_arr[i]){
                chack = true;
                System.out.print(i);
                break;
            }         
        }

        if(!chack){
            System.out.print(-1);
        }        
    }
}