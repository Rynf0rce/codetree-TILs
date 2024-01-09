import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TreeMap<Integer, Integer> m = new TreeMap<>();

        int n = sc.nextInt();

        for(int i = 1 ; i <= n ; i++){
            int num = sc.nextInt();
            if(!m.containsKey(num)){
                m.put(num, i);
            }
        }

        for(int key : m.keySet()){
            System.out.println(key + " " + m.get(key));
        }
    }
}