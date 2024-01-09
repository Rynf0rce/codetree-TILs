import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TreeMap<String, Integer> m = new TreeMap<>();

        int n = sc.nextInt();
        for(int i = 0 ; i < n ; i++){
            String str = sc.next();
            m.put(str, m.getOrDefault(str, 0) + 1);
        }

        Iterator<Map.Entry<String, Integer>> iter = m.entrySet().iterator();
        while(iter.hasNext()){
            Map.Entry<String, Integer> entry = iter.next();
            System.out.printf("%s %.4f\n", entry.getKey(), (float)(entry.getValue() * 100 / n));
        }
    }
}