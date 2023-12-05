import java.util.*;

public class Main {
    public static final int MAX_RANGE = 101;
    public static int[] cntArr = new int[MAX_RANGE];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(), output = -1;
        int[] arr = new int[N];
        for(int i = 0 ; i < N ; i ++){
            arr[i] = sc.nextInt();
            cntArr[arr[i]]++;
        }

        boolean triger = true;
        for(int i = 1 ; i < MAX_RANGE - 1 ; i++){
            if(cntArr[i] > 0){
                if(triger){
                    triger = false;
                    continue;
                }
                else{
                    if(cntArr[i] == 1){
                        output = i;
                    }
                    break;
                }
            }
        }
        
        if(output != -1){
            for(int i = 0 ; i < N ; i++){
                if(arr[i] == output){
                    output = i + 1;
                    break;
                }
            }
        }
        System.out.println(output);
    }
}