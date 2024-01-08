import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<String, Integer> m = new HashMap<>();

        int n = sc.nextInt();

        for(int i = 0 ; i < n ; i++){
            String str = sc.next();
            m.put(str, m.getOrDefault(str, 0) + 1);
        }

        Iterator<String> keys = m.keySet().iterator();
        int output = 0;

        while (keys.hasNext()) {
            String key = keys.next();
            output = Math.max(output, m.get(key));
        }

        System.out.print(output);
    }
}