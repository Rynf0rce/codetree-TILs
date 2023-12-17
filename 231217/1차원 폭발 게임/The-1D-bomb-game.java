import java.util.*;

public class Main {
    public static final int MAX_RANGE = 100;
    public static int[] arr = new int[MAX_RANGE + 1];

    public static void gravity(){
        int[] temp = new int[MAX_RANGE + 1];
        int idx = 1;
        boolean output = false;
        for(int i = 1 ; i <= MAX_RANGE ; i++){
            if(arr[i] != 0){
                temp[idx++] = arr[i];
            }
        }

        for(int i = 1 ; i <= MAX_RANGE ; i++){
            arr[i] = temp[i];
        }
    }

    public static void bomb(int range){
        boolean output = true;
        while(output){
            output = false;
            for(int i = 1 ; i < MAX_RANGE ; i++){
                int basis = arr[i], cnt = 0;
                if(basis == 0){
                    continue;
                }

                for(int j = i ; j < MAX_RANGE ; j++){
                    if(basis == arr[j]){
                        cnt++;
                    }
                    else{
                        break;
                    }
                }

                if(cnt >= range){
                    for(int j = 0 ; j < cnt ; j++){
                        arr[i+j] = 0;
                    }
                    output = true;
                }   
            }
            gravity();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(), M = sc.nextInt(), cnt = 0;
        for(int i = 1 ; i <= N ; i++){
            arr[i] = sc.nextInt();
        }

        bomb(M);

        for(int i = 1 ; i <= N ; i++){
            if(arr[i] > 0){
                cnt++;
            }
        }
        
        System.out.println(cnt);
        for(int i = 1 ; i <= cnt ; i++){
            System.out.println(arr[i]);
        }
        
    }
}