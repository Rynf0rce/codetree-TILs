import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String A = sc.next(), B = sc.next();
        int intA = 0, intB = 0, idx = 0;
        
        for(int i = 0 ; i < A.length() ; i++){
            if(A.charAt(i) >= '0' && A.charAt(i) <= '9'){
                idx++;
            }
            else{
                break;
            }
        }
        intA = Integer.parseInt(A.substring(0, idx));

        idx = 0;
        for(int i = 0 ; i < B.length() ; i++){
            if(B.charAt(i) >= '0' && B.charAt(i) <= '9'){
                idx++;
            }
            else{
                break;
            }
        }
        intB = Integer.parseInt(B.substring(0, idx));

        System.out.print(intA + intB);
    }
}