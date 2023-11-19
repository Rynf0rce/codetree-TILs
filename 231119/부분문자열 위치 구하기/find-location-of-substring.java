import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        String target = sc.next();
        int idx = 0, first_idx = -1;
        boolean judge = false;
        
        for(int i = 0 ; i < input.length() ; i++){
            if(input.charAt(i) == target.charAt(idx)){
                System.out.println("i : " + i + " idx :" + idx);
                first_idx = idx == 0 ? i : first_idx;
                if(first_idx + target.length() > input.length()){
                    first_idx = -1;
                    break;
                }
                else if(idx == target.length() - 1){
                    break;
                }
                idx++;
            }
            else{
                idx = 0;
                first_idx = -1;
            }
        }
        System.out.print(first_idx);
    }
}