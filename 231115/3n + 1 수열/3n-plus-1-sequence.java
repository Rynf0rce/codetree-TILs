import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();
        int conVal = input, cnt = 0;
        while(true){
            if(conVal ==1){
                break;
            }
            
            if(conVal % 2 == 0){
                 conVal /= 2;
            }
            else{
                conVal = conVal * 3 + 1;
            }
            cnt++;
            
        }
        System.out.print(cnt);
    }
}