import java.util.*;

public class Main {
    public static final int MAX_INT = 4000000;
    public static boolean[] arr = new boolean[MAX_INT + 1];
    public static ArrayList<Integer> primeList = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i = 2 ; i <= n ; i++){
            if(!arr[i]){
                primeList.add(i);
                int idx = i;
                int cnt = 2;
                while(i * cnt <= n){
                    arr[i * cnt] = true;
                    cnt++;
                }
            }
        }

        int ans = 0;
        for(int i = 0 ; i < primeList.size() ; i++){
            int j = i;
            int sum = primeList.get(i);
            while(sum < n){
                j++;
                sum += primeList.get(j);
            }

            if(sum == n){
                ans++;
            }
        }
        System.out.print(ans);
    }
}