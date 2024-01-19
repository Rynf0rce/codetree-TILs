import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TreeSet<Integer> sortSet = new TreeSet<>();
        HashMap<Integer, Integer> pointMap = new HashMap<>();

        int n = sc.nextInt();
        int q = sc.nextInt();
        for(int i = 0 ; i < n ; i++){
            int num = sc.nextInt();
            sortSet.add(num);
        }

        int idx = 0;
        for(Integer num : sortSet){
            pointMap.put(num, idx++);
        }

        for(int i = 0 ; i < q ; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            System.out.println(pointMap.get(b) - pointMap.get(a) + 1);
        }
    }
}