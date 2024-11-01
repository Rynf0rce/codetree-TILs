import java.util.*;

public class Main {
    public static final int MAX_VALUE = 10;
    public static Stack<Integer> s = new Stack<>();
    public static Stack<Integer> temp = new Stack<>();

    public static int ans = 0;
    public static int n = 0;

    public static boolean beautiful(){
        Stack<Integer> tempStack = (Stack<Integer>) s.clone();

        while(!tempStack.isEmpty()){
            int num = tempStack.peek();

            if(tempStack.size() < num){
                return false;
            }

            int cnt = 0;
            while(cnt != num){
                if(tempStack.pop() != num){
                    return false;
                }
                cnt++;
            }
        }

        return true;
    }

    public static void findVal(int idx){
        if(idx > n){
            if((beautiful())){
                ans++;
            }
            return;
        }

        for(int i = 1 ; i <= 4 ; i++){
            s.push(i);
            findVal(idx + 1);
            s.pop();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        findVal(1);
        System.out.print(ans);
        // s.push(2);
        // System.out.print(beautiful());
    }
}