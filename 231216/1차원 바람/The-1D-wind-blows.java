import java.util.*;

public class Main {
    public static final int MAX_RANGE = 100;
    public static int[][] arr2D = new int[MAX_RANGE][MAX_RANGE];
    public static int height;
    public static int width;
    public static void conFnc(int idx, char direction, int command){
        int temp = 0;
        switch(direction){
            case 'L' :
                temp = arr2D[idx][width - 1];
                for(int i = width - 1 ; i > 0 ; i--){
                    arr2D[idx][i] = arr2D[idx][i-1];
                }
                arr2D[idx][0] = temp;
                break;
            case 'R' :
                temp = arr2D[idx][0];
                for(int i = 0 ; i < width - 1 ; i++){
                    arr2D[idx][i] = arr2D[idx][i+1];
                }
                arr2D[idx][width - 1] = temp;
                break;
            default :
                return;
        }
          
        if(command <= 0 && idx > 0){
            for(int i = 0 ; i < width ; i++){
                if(arr2D[idx][i] == arr2D[idx-1][i]){
                    if(direction == 'L'){
                        conFnc(idx - 1, 'R', -1);
                    }
                    else{
                        conFnc(idx - 1, 'L', -1);
                    }
                    break;
                }
            }
        }

        if(command >= 0 && idx < height - 1){
            for(int i = 0 ; i < width ; i++){
                if(arr2D[idx][i] == arr2D[idx+1][i]){
                    if(direction == 'L'){
                        conFnc(idx + 1, 'R', 1);
                        
                    }
                    else{
                        conFnc(idx + 1, 'L', 1);
                    }
                    
                    break;
                }
            }            
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        height = sc.nextInt();
        width = sc.nextInt();
        int Q = sc.nextInt();

        for(int i = 0 ; i < height ; i++){
            for(int j = 0 ; j < width ; j++){
                arr2D[i][j] = sc.nextInt();
            }
        }

        for(int i = 0 ; i < Q ; i++){
            int idx = sc.nextInt();
            char direction = sc.next().charAt(0);
            conFnc(idx - 1, direction, 0);
        }

        for(int i = 0 ; i < height ; i++){
            for(int j = 0 ; j < width ; j++){
                System.out.print(arr2D[i][j] + " ");
            }
            System.out.println();
        }              
    }
}