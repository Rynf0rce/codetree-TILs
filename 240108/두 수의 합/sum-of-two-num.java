import java.util.*;

public class Main {
    public static int MAX_INPUT = 100000;
    public static int[] arr = new int[MAX_INPUT];

    public static int n, k;
    public static int cnt = 0;

    public static void BFS(int idx, int selected, int sum){
        if(selected == 2){
            if(sum == k){
                cnt++;
            }
            return;
        }

        for(int i = idx ; i < n ; i++){
            BFS(i + 1, selected + 1, sum + arr[i]);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();

        for(int i = 0 ; i < n ; i++){
            arr[i] = sc.nextInt();
        }

        BFS(0, 0, 0);

        System.out.print(cnt);
    }
}