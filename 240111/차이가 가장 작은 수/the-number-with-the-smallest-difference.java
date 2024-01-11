import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TreeSet<Integer> s = new TreeSet<>();

        int n = sc.nextInt();
        int m = sc.nextInt();

        for(int i = 0 ; i < n ; i++){
            int num = sc.nextInt();
            s.add(num);
        }

        int output = Integer.MAX_VALUE;
        int start = s.first();
        for(int i = 0 ; i < n - 1 ; i++){
            int target = start + m;
            if(s.ceiling(target) != null){
                int gap = s.ceiling(target) - start;
                output = Math.min(output, gap);
                if(output == m){
                    break;
                }
            }

            if(s.higher(start) == null){
                break;
            }

            start = s.higher(start);
        }
        System.out.println(output == Integer.MAX_VALUE ? -1 : output);
    }
}