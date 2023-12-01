import java.util.*;

public class Main {
    public static final int MAX_IDX = 1001;
    public static char[] arr;
    
    public static boolean specialLocation(int idx){
        int S_Min = 1002;
        int N_Min = 1002;
        for(int i = 0 ; i < arr.length ; i++){
            if(arr[i] == 'S'){
                S_Min = Math.min(S_Min, Math.abs(idx - i));
            }
            else if(arr[i] == 'N'){
                N_Min = Math.min(N_Min, Math.abs(idx - i));
            }
        }
        if(S_Min <= N_Min){
            return true;
        }
        else{
            return false;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        arr = new char[MAX_IDX];
        Arrays.fill(arr,'O');
        int T = sc.nextInt(), a = sc.nextInt(), b = sc.nextInt();
        for(int i = 0 ; i < T ; i++){
            char spell = sc.next().charAt(0);
            int idx = sc.nextInt();
            arr[idx] = spell;
        }
        int cnt = 0;
        for(int i = a ; i <= b ; i++){
            if(specialLocation(i)){
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}