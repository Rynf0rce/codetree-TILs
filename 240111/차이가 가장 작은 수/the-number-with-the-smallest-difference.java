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
            int end = start;
            for(int j = i + 1 ; j < n ; j++){
                end = s.higher(end);
                int gap = end - start;
                if(gap >= m){
                    output = Math.min(output, gap);
                    break;
                }
            }
            start = s.higher(start);
            if(start == m){
                break;
            }
        }
        System.out.println(output == Integer.MAX_VALUE ? -1 : output);
    }
}