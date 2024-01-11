import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TreeSet<Integer> s = new TreeSet<>();
        s.add(0);

        int minVal = Integer.MAX_VALUE;

        int n = sc.nextInt();
        for(int i = 0 ; i < n ; i++){
            int num = sc.nextInt();
            s.add(num);

            if(s.higher(num) != null){
                minVal = Math.min(minVal, s.higher(num) - num);
            }

            if(s.lower(num) != null){
                minVal = Math.min(minVal, num - s.lower(num));
            }
            System.out.println(minVal);
        }
    }
}