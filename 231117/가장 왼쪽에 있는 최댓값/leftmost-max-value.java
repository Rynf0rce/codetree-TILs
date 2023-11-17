import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n], arrCnt = new int[1001];
        int maxVal = 0, pointer = 0, idx = arr.length;
        // arr = new int[]{3,1,2,3,4};
        for(int i = 0; i < arr.length ; i++){
            arr[i] = sc.nextInt();
            arrCnt[arr[i]]++;
        }




        while(idx > 1){
            maxVal = 0;
            for(int i = 0 ; i < idx ; i++){
                if(arr[i] > maxVal){
                    maxVal = arr[i];
                    pointer = i;
                }
            }

            System.out.print(pointer + 1 + " ");

            if(arrCnt[maxVal] > 1){
                idx = pointer;
                continue;
            }
            else{
                idx = 0;
                System.out.print(idx + 1);
                break;
            }
        }   
    }
}