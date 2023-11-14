import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        String output = "Fall";
        
        if(m >= 1 && m <= 12){
            if(m == 12 || m <= 2){
                output = "Winter";
            }
            else if(m <= 5){
                output = "Spring";
            }
            else if(m <= 8){
                output ="Summer";
            }
            else{
                output = "Fall";
            }
        }
        System.out.print(output);
    }
}