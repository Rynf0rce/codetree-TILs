import java.util.*;

public class Main {
    public static final int MAX_INPUT = 100000;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] wordArr = new String[MAX_INPUT + 1];
        HashMap<String, Integer> engMap = new HashMap<>();

        int n = sc.nextInt();
        int m = sc.nextInt();

        for(int i = 1 ; i <= n ; i++){
            wordArr[i] = sc.next();
            engMap.put(wordArr[i], i);
        }

        for(int i = 0 ; i < m ; i++){
            String input = sc.next();
            if(engMap.containsKey(input)){
                System.out.println(engMap.get(input));
            }
            else{
                System.out.println(wordArr[Integer.parseInt(input)]);
            }
        }
    }
}