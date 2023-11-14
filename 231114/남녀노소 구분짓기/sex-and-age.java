import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int gender = sc.nextInt();
        int old = sc.nextInt();
        String output = "";

        if(old < 19){
            if(gender == 0){
                output = "BOY";
            }
            else{
                output = "GIRL";
            }
        }
        else{
            if(gender == 0){
                output = "MAN";
            }
            else{
                output = "WOMAN";
            }
        }
        System.out.print(output);
    }
}