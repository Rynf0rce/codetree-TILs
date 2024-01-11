import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        TreeSet<Integer> s = new TreeSet<>();

        int n = sc.nextInt();
        int m = sc.nextInt();

        for(int i = 0 ; i < m ; i++){
            int num = sc.nextInt();
            s.add(num);
            int maxVal = 0;
            for(Integer trash : s){
                // System.out.println(trash);
                int start = (s.lower(trash) == null ? -1 : s.lower(trash));
                int end = (s.higher(trash) == null ? n + 1 : s.higher(trash));
                // System.out.println(start + " " + end);
                int preMax = Math.max(trash - start - 1, end - trash - 1);
                maxVal = Math.max(maxVal, preMax);
            }
            System.out.println(maxVal);
        }
    }
}