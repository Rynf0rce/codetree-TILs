import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String A = sc.nextLine(), output = "";
        char standard = A.charAt(0);
        int cnt = 1;
        for(int i = 0 ; i < A.length() ; i++){
            if(i >= A.length() -1 ){
                output = output + standard + cnt;
                break;
            }

            if(A.charAt(i) == A.charAt(i+1)){
                cnt++;
            }
            else{
                output = output + standard + cnt;
                standard = A.charAt(i+1);
                cnt = 1;

            }
        }
        System.out.printf("%d\n%s", output.length(), output);
    }
}