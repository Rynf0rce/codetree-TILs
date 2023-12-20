import java.util.*;

public class Main {
    public static ArrayList<Integer> vector = new ArrayList<>();
    public static final int MAX_INT = 4;
    public static boolean chack(){
        int[] chackNum = new int[MAX_INT + 1];
        int preVal = vector.get(0);
        int curVal = 0;
        for(int i = 0 ; i < vector.size() ; i++){
            curVal = vector.get(i);
            chackNum[curVal]++;
            if( (preVal != curVal)  && chackNum[preVal] % preVal != 0){
                return false;
            }
            else{
                preVal = curVal;
            }
        }

        if(chackNum[curVal] % curVal != 0){
            return false;
        }
        
        return true;
    }
    public static int beautifulNum(int digit, int n){
        int cnt = 0;
        if(digit > n){
            return chack() ? 1 : 0;
        }
        
        for(int i = 1 ; i <= 4 ; i++){
            vector.add(i);
            cnt += beautifulNum(digit + 1, n);
            vector.remove(vector.size() - 1);
        }

        return cnt;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(beautifulNum(1, n));
    }
}