import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<Character, Integer> map = new HashMap<>();
        char[] arr = sc.next().toCharArray();

        for(int i = 0 ; i < arr.length ; i++){
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }

        for(int i = 0 ; i < arr.length ; i++){
            if(map.get(arr[i]) == 1){
                System.out.print(arr[i]);
                System.exit(0);
            }
        }

        System.out.print("None");
    }
}