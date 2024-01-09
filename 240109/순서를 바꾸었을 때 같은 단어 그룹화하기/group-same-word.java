import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = sc.nextInt();
        for(int i = 0 ; i < n ; i++){
            String str = sc.next();
            int value = 0;
            for(int j = 0 ; j < str.length() ; j++){
                value += str.charAt(j) - 'A';
            }
            map.put(value, map.getOrDefault(value, 0) + 1);
        }

        int maxVal = 0;

        for(Integer key : map.keySet()){
            maxVal = Math.max(maxVal, map.get(key));
        }

        System.out.print(maxVal);
    }
}