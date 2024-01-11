import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TreeSet<Integer> s = new TreeSet<>();
        s.add(0);

        int n = sc.nextInt();
        for(int i = 0 ; i < n ; i++){
            int num = sc.nextInt();
            s.add(num);

            int minVal = Integer.MAX_VALUE;
            
            for(Integer val : s){
                if(s.higher(val) == null){
                    break;
                }
                minVal = Math.min( minVal, (s.higher(val) - val) );
            }
            System.out.println(minVal);
        }
    }
}