import java.util.*;

public class Main {
    public static final int EDGE = 3;
    public static final int NUM_RANGE = 9;
    public static char[] arr;

    public static boolean win(int a, int b){
        int cnt_a = 0, cnt_b = 0;
        for(int i = 0 ; i < EDGE ; i++){
            cnt_a = 0;
            cnt_b = 0;
            for(int j = i ; j < EDGE * EDGE ; j += 3){
                if(arr[j] - '0'== a){
                    cnt_a++;
                }
                else if(arr[j] - '0' == b){
                    cnt_b++;
                }
            }
            if(cnt_a > 0 && cnt_b > 0 && cnt_a + cnt_b == EDGE){
                return true;
            }
        }

        for(int i = 0 ; i < EDGE * EDGE ; i += 3){
            cnt_a = 0;
            cnt_b = 0;
            for(int j = i ; j < i + EDGE ; j++){
                if(arr[j] - '0' == a){
                    cnt_a++;
                }
                else if(arr[j] - '0' == b){
                    cnt_b++;
                }
            }
            if(cnt_a > 0 && cnt_b > 0 && cnt_a + cnt_b == EDGE){
                return true;
            }
        }

        cnt_a = 0;
        cnt_b = 0;
        for(int i = 0 ; i < EDGE * EDGE ; i += 4){
            if(arr[i] - '0' == a){
                cnt_a++;
            }
            else if(arr[i] - '0' == b){
                cnt_b++;
            }
            
            if(cnt_a > 0 && cnt_b > 0 && cnt_a + cnt_b == EDGE){
                return true;
            }
        }

        cnt_a = 0;
        cnt_b = 0;
        for(int i = 2 ; i < 7 ; i += 2){
            if(arr[i] - '0' == a){
                cnt_a++;
            }
            else if(arr[i] - '0' == b){
                cnt_b++;
            }
            
            if(cnt_a > 0 && cnt_b > 0 && cnt_a + cnt_b == EDGE){
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = "";
        for(int i = 0 ; i < EDGE ; i++){
            str += sc.next();
        }
        arr = str.toCharArray();
        int output = 0;
        for(int i = 1 ; i <= NUM_RANGE - 1 ; i++){
            for(int j = i + 1 ; j <= NUM_RANGE ; j++){
                if(win(i,j)){
                    output++;
                }
            }
        }

        System.out.println(output);
        
    }
}