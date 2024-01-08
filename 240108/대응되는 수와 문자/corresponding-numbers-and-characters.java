import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<String, String> intMap = new HashMap<>();
        HashMap<String, String> engMap = new HashMap<>();

        int n = sc.nextInt();
        int m = sc.nextInt();

        for(int i = 0 ; i < n ; i++){
            String str = sc.next();
            engMap.put(str, Integer.toString(i + 1));
            intMap.put(Integer.toString(i + 1), str);
        }

        for(int i = 0 ; i < m ; i++){
            String input = sc.next();
            if(engMap.containsKey(input)){
                System.out.println(engMap.get(input));
            }
            else{
                System.out.println(intMap.get(input));
            }
        }
    }
}