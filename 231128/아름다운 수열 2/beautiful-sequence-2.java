import java.util.*;

public class Main {
    public static int[] arrA;
    public static int[] arrB;

    public static boolean contain(int idx){
        int[] tempArrB = arrB.clone();
        int cnt = 0;
        for(int i = 0 ; i < tempArrB.length ; i++){
            if(arrA[idx] == tempArrB[i]){
                tempArrB[i] = -1;
                i = -1;
                idx++;
                cnt++;
                if(cnt >= tempArrB.length){
                    return true;
                }
            }
        }
        return false;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(), M = sc.nextInt();
        arrA = new int[N];
        arrB = new int[M];
        for(int i = 0 ; i < arrA.length ; i++){
            arrA[i] = sc.nextInt();
        }
        for(int i = 0 ; i < arrB.length ; i++){
            arrB[i] = sc.nextInt();
        }
        
        int output = 0;
        for(int i = 0 ; i < arrA.length - arrB.length + 1 ; i++){
            if(contain(i)){
                output++;
            }
        }
        System.out.println(output);
    }
}