import java.util.*;

public class Main {
    public static void move(int[] conA, int[] conB){
        int tempA = conA[conA.length - 1];
        for(int i = conA.length - 1 ; i > 0 ; i--){
            conA[i] = conA[i-1];
        }
        int tempB = conB[conB.length - 1];
        for(int i = conB.length - 1 ; i > 0 ; i--){
            conB[i] = conB[i-1];
        }
        conB[0] = tempA;
        conA[0] = tempB;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), t = sc.nextInt();
        int[] conA = new int[n], conB = new int[n];
        for(int i = 0 ; i < 2 * n ; i++){
            if(i < n){
                conA[i] = sc.nextInt();
            }
            else{
                conB[i%n] = sc.nextInt();
            }
        }
        while(t>0){
            move(conA, conB);
            t--;
        }

        for(int i = 0 ; i < n ; i++){
            System.out.print(conA[i] + " ");
        }
        System.out.println();
        for(int i = 0 ; i < n ; i++){
            System.out.print(conB[i] + " ");
        }
        
    }
}