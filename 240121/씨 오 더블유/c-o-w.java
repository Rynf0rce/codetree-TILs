import java.util.*;

public class Main {
    public static int MAX_LENGTH = 100000;
    public static int[] rightArr_C = new int[MAX_LENGTH];
    public static int[] leftArr_W = new int[MAX_LENGTH];
    public static boolean[] centerArr_O = new boolean[MAX_LENGTH]; // o

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        char[] inputArr = sc.next().toCharArray();

        int cNum = 0;
        int wNum = 0;
        for(int i = 0 ; i < n ; i++){
            if(inputArr[i] == 'C'){
                cNum++;
            }
            else if(inputArr[i] == 'O'){
                centerArr_O[i] = true;
            }
            rightArr_C[i] = cNum;
        }

        for(int i = n - 1 ; i >= 0 ; i--){
            if(inputArr[i] == 'W'){
                wNum++;
            }
            leftArr_W[i] = wNum;
        }

        int output = 0;
        for(int i = 1 ; i < n - 1 ; i++){
            if(centerArr_O[i]){
                output += rightArr_C[i - 1] * leftArr_W[i + 1];
            }
        }
        System.out.print(output);
    }
}