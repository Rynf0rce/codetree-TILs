import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int[][] arr = new int[num][2];
        for(int i = 0 ; i < arr.length ; i++){
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
        }

        double distance = 0, minDisance = Integer.MAX_VALUE;
        for(int i = 0 ; i < arr.length ; i++){
            distance = Integer.MAX_VALUE;
            for(int j = 0 ; j < arr.length ; j++){
                if(i == j){
                    continue;
                }
                distance = Math.pow(arr[i][0] - arr[j][0],2) + Math.pow(arr[i][1] - arr[j][1], 2);
            }
            minDisance = Math.min(minDisance, distance);
        }
        System.out.print((int)minDisance);
    }
}