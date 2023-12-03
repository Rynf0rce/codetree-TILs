import java.util.*;

public class Main {
    public static final int INPUT_MAX = 40;
    public static int[] inputArr = new int[15];
    public static boolean isTrueAnswer(int A, int B, int C, int D){
        int[] answerArr = new int[]{A, B, C, D, A + B, B + C, C + D, D + A, A + C, B + D, A + B + C, A + B + D, A + C + D, B + C + D, A + B + C + D};
        Arrays.sort(answerArr);
        for(int i = 0 ; i < answerArr.length ; i++){
            if(inputArr[i] != answerArr[i]){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for(int i = 0 ; i < inputArr.length ; i++){
            inputArr[i] = sc.nextInt();
        }

        Arrays.sort(inputArr);
        boolean triger = true;
        for(int A = 1 ; A < INPUT_MAX ; A++){
            for(int B = 1 ; B < INPUT_MAX ; B++){
                for(int C = 1; C < INPUT_MAX ; C++){
                    for(int D = 1; D < INPUT_MAX ; D++){
                        if(triger && isTrueAnswer(A,B,C,D)){
                            System.out.printf("%d %d %d %d\n", A, B, C, D);
                            triger = false;
                            break;
                        }
                    }
                }
            }
        }
    }
}