import java.util.*;

public class Main {
    public static final int MAX_LENGTH = 200;
    public static char[] arr;
    public static HashMap<Character, Integer> hm = new HashMap<>();
    public static ArrayList<Character> operator = new ArrayList<>();
    public static long ans = 0;

    public static long check(){
        long ans = hm.get(arr[0]);
        for(int i = 2 ; i < arr.length ; i += 2){
            switch(operator.get(i/2 - 1)){
                case '+' :
                    ans += hm.get(arr[i]);
                break;
                case '-' :
                    ans -= hm.get(arr[i]);
                break;
                case '*' :
                    ans *= hm.get(arr[i]);
                break;
            }
        }
        return ans;
    }

    public static void simulation(int idx){
        if(idx > arr.length / 2){
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
        for(int i = 1 ; i < arr.length ; i += 2){
            operator.add(arr[i]);
        }

        simulation(0);

        System.out.print(ans);
    }
}