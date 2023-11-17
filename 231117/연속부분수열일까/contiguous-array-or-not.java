import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n1 = sc.nextInt(), n2 = sc.nextInt();
        int[] arrA = new int[n1], arrB = new int[n2];
        boolean answer = false;
        for(int i = 0 ;  i < arrA.length ; i++){
            arrA[i] = sc.nextInt();
        }
        for(int i = 0 ; i < arrB.length ; i++){
            arrB[i] = sc.nextInt();
        }

        // arrA = new int[]{9, 2, 4, 1, 3, 3, 1, 4, 6, 8};
        // arrB = new int[]{4, 1, 3, 3, 1, 4};

        for(int i = 0 ; i < arrA.length ; i++){
            if(arrA[i] == arrB[0]){
                for(int j = 1 ; j < arrB.length ; j++){
                    if(arrA[i + j] != arrB[j]){
                        break;
                    }
                    else if(j == arrB.length - 1){
                        answer = true;
                    }
                }
            }
            else if(answer == true){
                break;
            }
        }

        System.out.print(answer ? "Yes" : "No");
    }
}