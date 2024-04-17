import java.util.*;

public class Main {
    public static final int MAX_TEMPERATURE = 1000;
    public static int C;
    public static int G;
    public static int H;
    public static int workload(int Ta, int Tb, int temperature){
        if(temperature < Ta){
            return C;
        }
        else if(temperature > Tb){
            return H;
        }
        else {
            return G;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(), maxVal = Integer.MIN_VALUE;
        C = sc.nextInt();
        G = sc.nextInt();
        H = sc.nextInt();
        int[][] arr = new int[N][2];
        for(int i = 0 ; i < arr.length ; i++){
            for(int j = 0 ; j < arr[i].length ; j++){
                arr[i][j] = sc.nextInt();
            }
        }

        for(int i = 0 ; i <= MAX_TEMPERATURE ; i++){
            int curWorkLoad = 0;
            for(int j = 0 ; j < arr.length ; j++){
                curWorkLoad += workload(arr[j][0], arr[j][1], i);
            }
            maxVal = Math.max(maxVal, curWorkLoad);
        }
        System.out.println(maxVal);
    }
}