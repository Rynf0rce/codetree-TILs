import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String A = sc.nextLine(), B = sc.nextLine();
        char[] a_Arr = A.toCharArray(), b_Arr = B.toCharArray();
        int push = 0;
        for(int i = 0 ; i < b_Arr.length ; i++){
            if(b_Arr[i] == 'L'){
                push--;
            }
            else{
                push++;
            }
        }

        char[] taskArr = new char[A.length()];
        // push = 0;
        // R
        if(push > 0){
            for(int i = 0 ; i < taskArr.length - push ; i++){
                taskArr[i + push] = a_Arr[i];
                if(i < push){
                    taskArr[i] = a_Arr[taskArr.length - push + i];
                }
            }
        }
        // L
        else if(push < 0){
            push = Math.abs(push);
            for(int i = 0 ; i < taskArr.length ; i++){
                if(i >= push){
                    taskArr[i - push] = a_Arr[i];
                }
                else{
                    taskArr[taskArr.length - push + i] = a_Arr[i];
                } 
            }
        }
        else{
            taskArr = Arrays.copyOf(a_Arr, a_Arr.length);
        }
        A = String.valueOf(taskArr);
        System.out.print(A);
    }
}