import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        String target = sc.next();
        boolean triger = false;

        input = "water";
        target = "water";

        for(int i = 0 ; i < input.length() ; i++){
            if(input.charAt(i) == target.charAt(0) && i + target.length() <= input.length()){
                if(target.length() == 1){
                    triger = true;
                }
                else{
                    for(int j = 1 ; j < target.length() ; j++){
                        if(input.charAt(i+j) != target.charAt(j)){
                            break;
                        }
                        else if(j == target.length() - 1){
                            triger = true;
                        }
                    }

                }
            }
            if(triger){
                System.out.print(i);
                break;
            }
        }
    }
}