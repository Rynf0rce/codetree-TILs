import java.util.*;

public class Main {
    public static final int MAX_LENGTH = 200;
    public static char[] arr;
    public static HashMap<Character, Integer> hm = new HashMap<>();
    public static long ans = Long.MIN_VALUE;

    public static long check(){
        long ans = hm.get(arr[0]);
        for(int i = 1 ; i < arr.length ; i += 2){
            switch(arr[i]){
                case '+' :
                    ans += hm.get(arr[i + 1]);
                break;
                case '-' :
                    ans -= hm.get(arr[i + 1]);
                break;
                case '*' :
                    ans *= hm.get(arr[i + 1]);
                break;
            }
        }
        return ans;
    }

    public static void simulation(int idx){
        if(idx > 6){
            ans = Math.max(ans, check());
            return;
        }

        for(int i = 1 ; i <= 4 ; i++){
            hm.put((char)('a' + idx), i);
            simulation(idx + 1);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        arr = sc.next().toCharArray();

        simulation(0);

        System.out.printf("%d", ans);
    }
}