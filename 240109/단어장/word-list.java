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

        for(String key : m.keySet()){
            System.out.println(key + " " + m.get(key));
        }
    }
}