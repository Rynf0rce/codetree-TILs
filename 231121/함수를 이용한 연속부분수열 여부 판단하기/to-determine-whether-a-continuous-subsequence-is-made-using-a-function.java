import java.util.*;

public class Main {
    public static boolean conFuc(int[] arrA, int[] arrB){
        if(arrB.length > arrA.length){
            return false;
        }

        int cnt = 0;
        for(int i = 0 ; i <= arrA.length - arrB.length; i++){
            cnt = 0;
            for(int j = 0 ; j < arrB.length ; j++){
                if(arrA[i+j] == arrB[j]){
                    cnt++;
                }
                else{
                    break;
                }
            }
            if(cnt == arrB.length){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt(), b = sc.nextInt();
        int[] arrA = new int[a], arrB = new int[b];
        for(int i = 0 ; i < arrA.length ; i++){
            arrA[i] = sc.nextInt();
        }
        for(int i = 0 ; i < arrB.length ; i++){
            arrB[i] = sc.nextInt();
        }
        System.out.print(conFuc(arrA, arrB) ? "Yes" : "No");
    }
}