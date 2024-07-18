import java.util.*;

public class Main {
    public static ArrayList<Integer> input = new ArrayList<>();
    public static int n;
    public static int total;
    public static int minVal = Integer.MAX_VALUE;

    public static void select(int idx, int value, int cnt){
        if(cnt >= n){
            minVal = Math.min(minVal, Math.abs((total - value) - value));
            return;
        }

        for(int i = idx ; i < input.size() ; i++){
            select(i + 1, value + input.get(i), cnt + 1);
        }
    }
      
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        for(int i = 0 ; i < 2 * n ; i++){
            int num = sc.nextInt();
            total += num;
            input.add(num);
        }

        select(0, 0, 0);

        System.out.print(minVal);
    }
}