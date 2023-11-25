import java.util.*;

public class Main {
    public static int MAX_INPUT = 1000;
    public static int MAX_LIMIT = 1000;
    public static int MAX_VALUE = 1000;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[MAX_INPUT];
        int[] judgeArr = new int[MAX_INPUT];
        int N = sc.nextInt(), T = sc.nextInt(), idx = 0;   
        for(int i = 0 ; i < N ; i++){
            arr[i] = sc.nextInt();
        }
        //arr = new int[]{2,1,10,3,2,7};
        //N = 6;
        //T = 8;
        for(int i = 0 ; i < N ; i++){
            if(arr[i] <= T){
                //System.out.println("chack i : "+ i);
                judgeArr[i] = 0;
            }
            else{
                if(i == 0 || judgeArr[i-1] == 0){
                    idx++;
                    judgeArr[i] = idx;
                }
                else if(arr[i] - arr[i-1] > 0){
                    judgeArr[i] = idx;
                    
                }
                else{
                    idx++;
                    judgeArr[i] = idx;
                }
            }
        }

        int cnt = 1, maxVal = Integer.MIN_VALUE;
        for(int i = 1 ; i < N ; i++){
            if(judgeArr[i] != 0 && judgeArr[i] == judgeArr[i-1]){
                cnt++;
            }
            else{
                cnt = 1;
            }

            if(cnt > maxVal){
                maxVal = cnt;
            }
        }
    System.out.print(maxVal);
        
    }
}