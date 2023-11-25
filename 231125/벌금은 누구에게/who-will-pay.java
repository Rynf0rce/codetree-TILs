import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int Students = sc.nextInt(), tasks = sc.nextInt(), limit = sc.nextInt();
        int[] taskArr = new int[tasks], studentArr = new int[Students + 1];
        for(int i = 0 ; i < tasks ; i++){
            taskArr[i] = sc.nextInt();
        }

        boolean chack = true;
        for(int i = 0 ; i < tasks ; i++){
            studentArr[taskArr[i]]++;
            if(studentArr[taskArr[i]] >= limit){
                System.out.print(taskArr[i]);
                chack = false;
                break;
            }
        }
        if(chack){
            System.out.print(-1);
        }
    }
}