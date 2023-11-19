import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int cutline = 0;
        while(str.length() > 1){
            cutline = sc.nextInt();
            if(cutline <= str.length()){
                str = str.substring(0, cutline) + str.substring(cutline + 1);
            }
            else{
                str = str.substring(0, str.length() - 1);
            }
            
            System.out.println(str);
        }
    }
}