import java.util.*;

public class Main {
    public static final int MAX_ELEMENT = 100000;
    public static int[] inputArr = new int[MAX_ELEMENT];
    public static int[] findArr = new int[MAX_ELEMENT];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        HashMap<Integer, Integer> map = new HashMap<>();

        int n = sc.nextInt();
        int m = sc.nextInt();

        for(int i = 0 ; i < n ; i++){
            inputArr[i] = sc.nextInt();
        }

        for(int i = 0 ; i < m ; i++){
            findArr[i] = sc.nextInt();
        }

        for(int i = 0 ; i < n ; i++){
            if(map.containsKey(inputArr[i])){
                int cnt = map.get(inputArr[i]);
                map.put(inputArr[i], cnt + 1);
            }
            else{
                map.put(inputArr[i], 1);
            }
        }

        for(int i = 0 ; i < m ; i++){
            System.out.print(map.getOrDefault(findArr[i], 0) + " ");
        }
    }
}