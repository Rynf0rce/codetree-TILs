import java.util.Scanner;

public class Main {
    public static int[] arr;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        arr = new int[n];
        for(int i = 0; i < arr.length ; i++){
            arr[i] = sc.nextInt();
        }

        int minVal = Integer.MAX_VALUE;
        for(int i = 0 ; i < arr.length ; i++){
            arr[i] *= 2;
            for(int j = 0 ; j < arr.length ; j++){
                int sum = 0;
                int cnt = 0;
                int[] tempArr = new int[n-1];
                for(int k = 0 ; k < arr.length ; k++){
                    if(k == j){
                        continue;
                    }
                    tempArr[cnt++] = arr[k];
                }
                
                for(int k = 0 ; k < tempArr.length - 1 ; k++){
                    sum += Math.abs(tempArr[k] - tempArr[k+1]);
                }
                minVal = Math.min(minVal, sum);
            }
            arr[i] /= 2;
        }
        System.out.println(minVal);
    }
}