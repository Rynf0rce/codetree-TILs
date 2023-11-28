import java.util.*;

public class Main {
    public static int factorial(int i){
        if(i <= 1){
            return 1;
        }
        return factorial(i-1) * i;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(), M = sc.nextInt();
        int[] arrA = new int[N], arrB = new int[M];
        for(int i = 0 ; i < arrA.length ; i++){
            arrA[i] = sc.nextInt();
        }
        for(int i = 0 ; i < arrB.length ; i++){
            arrB[i] = sc.nextInt();
        }
        
        int cnt = 0, output = 0;
        boolean triger = true;
        int[] tempArrB = arrB.clone();
        for(int i = 0 ; i < arrA.length ; i++){
            triger = true;
            for(int j = 0 ; j < arrB.length ; j++){
                if(arrA[i] == tempArrB[j]){
                    tempArrB[j] = 0;
                    triger = false;
                    cnt++;
                    break;
                }
            }
            if(triger){
                cnt = 0;
                tempArrB = arrB.clone();
            }
            if(cnt == arrB.length){
                output++;
            }
        }
        System.out.print(output);
    }
}