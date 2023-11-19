import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        String target = sc.next();
        boolean triger = true;
        int idx = 0;

        //input = "aaabbb";
        //target = "ab";


        while(triger){
            //System.out.println(input + " current idx : " + idx);
            if(target.length() + idx > input.length()){
                //System.out.println("break : " +  target.length() + idx + " " + input.length());
                break;
            }

            if(input.substring(0 + idx, target.length() + idx).equals(target)){
                input = input.substring(0, idx) + input.substring(idx + target.length());
                idx = 0;
                continue;
            }
            idx++;
        }
        System.out.print(input);
    }
}